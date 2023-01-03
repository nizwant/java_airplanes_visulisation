package gui;

import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MapOrganiser {
    private final JLabel _map;
    private final ImageWrapper _image;
    private double _mapScale;
    private int _mapXPos;
    private int _mapYPos;
    private int _mapMoveStep;

    public MapOrganiser() {
        this.ResetPosCalled();

        _map = new JLabel();

        try {
            _image = new ImageWrapper(Constants.RESOURCES_PATH + "/map.jpg");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void MoveToNorthCalled() {
        System.out.println("move to north called");

        _mapYPos += _mapMoveStep;
    }

    public void MoveToSouthCalled() {
        System.out.println("move to south called");

        _mapYPos -= _mapMoveStep;
    }

    public void MoveToWestCalled() {
        System.out.println("move to west called");

        _mapXPos += _mapMoveStep;
    }

    public void MoveToEastCalled() {
        System.out.println("move to east called");

        _mapXPos -= _mapMoveStep;
    }

    public void ResetPosCalled() {
        System.out.println("reset pos called");

        _mapScale = Constants.INIT_SCALE;
        _mapXPos = Constants.INIT_MAP_POS_X;
        _mapYPos = Constants.INIT_MAP_POS_Y;
        _mapMoveStep = Constants.INIT_MOVE_STEP;
    }

    public void ZoomInCalled() {
        System.out.println("zoom in called");

        // change position, scale and move step

        _mapScale *= (100 + Constants.SCALE_BOOST) / 100;
    }

    public void ZoomOutCalled() {
        System.out.println("zoom out called");

        // change position, scale and move step

        _mapScale /= (100 + Constants.SCALE_BOOST) / 100;
    }

    public void PinMap(Container pCon) {
        pCon.add(_map);
    }

    public void DrawMap() {
        System.out.println("draw map");

        int newWidth = (int) ((double) _image.GetWidth() * _mapScale);
        int newHeight = (int) ((double) _image.GetHeight() * _mapScale);

        ImageIcon icon = new ImageIcon(_image.GetResized(newWidth, newHeight));

        _map.setSize(new Dimension(newWidth, newHeight));

        _map.setIcon(icon);

        _map.setBounds(_mapXPos, _mapYPos, _map.getWidth(), _map.getHeight());
    }
}