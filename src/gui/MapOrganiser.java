package gui;

import constants.Constants;
import interfaces.Pinnable;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MapOrganiser implements Pinnable {
    private final ImageWrapper _image;
    private final JLabel _map;
    private double _mapScale;
    private int _mapXPos;
    private int _mapYPos;
    private int _zoomInClickedCounter;

    public MapOrganiser() {
        try {
            _image = new ImageWrapper(Constants.RESOURCES_PATH + "/map@pic.jpg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        _map = new JLabel();
        _map.setName("MAP");

        this.ResetPosCalled();
    }

    public void MoveToNorthCalled() {
        System.out.println("move to north called");

        _mapYPos += Constants.MAP_MOVE_STEP;

        // do not let move out of map
        this.MapCalibration();
    }

    public void MoveToSouthCalled() {
        System.out.println("move to south called");

        _mapYPos -= Constants.MAP_MOVE_STEP;

        // do not let move out of map
        this.MapCalibration();
    }

    public void MoveToWestCalled() {
        System.out.println("move to west called");

        _mapXPos += Constants.MAP_MOVE_STEP;

        // do not let move out of map
        this.MapCalibration();
    }

    public void MoveToEastCalled() {
        System.out.println("move to east called");

        _mapXPos -= Constants.MAP_MOVE_STEP;

        // do not let move out of map
        this.MapCalibration();
    }

    public void ResetPosCalled() {
        System.out.println("reset pos called");

        _mapScale = Constants.INIT_SCALE;
        _mapXPos = Constants.INIT_MAP_POS_X;
        _mapYPos = Constants.INIT_MAP_POS_Y;
        _zoomInClickedCounter = 0;

        this.RescaleMap();

        this.MapCalibration();
    }

    public void ZoomInCalled() {
        System.out.println("zoom in called");

        if (_zoomInClickedCounter == Constants.ZOOM_IN_COUNT_LIMIT) {
            // cannot zoom in more than 5 times
            System.out.println("cannot zoom in more than 5 times");
            return;
        }

        _zoomInClickedCounter++;

        // change position, scale and move step

        _mapScale *= (100 + Constants.SCALE_BOOST) / 100;

        _mapXPos *= (100 + Constants.SCALE_BOOST) / 100;
        _mapYPos *= (100 + Constants.SCALE_BOOST) / 100;

        // I know it can be simplified, but simplified version is not clear enough to quickly understand how
        // formula works
        // _mapXPos -= (int) ((double) Constants.WINDOW_WIDTH * Constants.SCALE_BOOST / 100 * 0.5);
        // _mapYPos -= (int) ((double) Constants.WINDOW_HEIGHT * Constants.SCALE_BOOST / 100 * 0.5);
        _mapXPos -= (int) ((double) Constants.WINDOW_WIDTH * ((100 + Constants.SCALE_BOOST) / 100 - 1.0) * 0.5);
        _mapYPos -= (int) ((double) Constants.WINDOW_HEIGHT * ((100 + Constants.SCALE_BOOST) / 100 - 1.0) * 0.5);

        this.RescaleMap();

        this.MapCalibration();
    }

    public void ZoomOutCalled() {
        System.out.println("zoom out called");

        if (_zoomInClickedCounter == 0) {
            // cannot zoom out while not zoomed in
            System.out.println("cannot zoom out while not zoomed in");
            return;
        }

        _zoomInClickedCounter--;

        // change position, scale and move step

        // I know it can be simplified, but simplified version is not clear enough to quickly understand how
        // formula works
        // _mapXPos += (int) ((double) Constants.WINDOW_WIDTH * Constants.SCALE_BOOST / 100 * 0.5);
        // _mapYPos += (int) ((double) Constants.WINDOW_HEIGHT * Constants.SCALE_BOOST / 100 * 0.5);
        _mapXPos += (int) ((double) Constants.WINDOW_WIDTH * ((100 + Constants.SCALE_BOOST) / 100 - 1.0) * 0.5);
        _mapYPos += (int) ((double) Constants.WINDOW_HEIGHT * ((100 + Constants.SCALE_BOOST) / 100 - 1.0) * 0.5);

        _mapXPos /= (100 + Constants.SCALE_BOOST) / 100;
        _mapYPos /= (100 + Constants.SCALE_BOOST) / 100;

        _mapScale /= (100 + Constants.SCALE_BOOST) / 100;

        this.RescaleMap();

        this.MapCalibration();
    }

    @Override
    public void PinTo(Container pContainer) {
        pContainer.add(_map);
    }

    public void DrawMap() {
        System.out.println("draw map");

        _map.setBounds(_mapXPos, _mapYPos, _map.getWidth(), _map.getHeight());
    }

    private void RescaleMap() {
        int newWidth = (int) ((double) _image.GetOriginalWidth() * _mapScale);
        int newHeight = (int) ((double) _image.GetOriginalHeight() * _mapScale);

        ImageIcon icon = new ImageIcon(_image.Resize(newWidth, newHeight).GetCurrentImage());
        _map.setSize(new Dimension(newWidth, newHeight));
        _map.setIcon(icon);
    }

    private void MapCalibration() {
        int deltaX = _image.GetCurrentWidth() - Constants.WINDOW_WIDTH;
        if (_mapXPos < -deltaX) _mapXPos = -deltaX;

        if (_mapXPos > 0) _mapXPos = 0;

        int deltaY = _image.GetCurrentHeight() - Constants.WINDOW_HEIGHT;
        if (_mapYPos < -deltaY) _mapYPos = -deltaY;

        if (_mapYPos > 0) _mapYPos = 0;
    }

    public int GetMapXPos() {
        return _mapXPos;
    }

    public int GetMapYPos() {
        return _mapYPos;
    }

    public int GetCurrentMapWidth() {
        return _image.GetCurrentWidth();
    }

    public int GetCurrentMapHeight() {
        return _image.GetCurrentHeight();
    }
}