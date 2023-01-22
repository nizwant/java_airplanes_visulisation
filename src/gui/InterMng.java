package gui;

import constants.Constants;
import planes.Airport;
import planes.PlaceableObject;
import planes.Plane;

import javax.swing.*;

import java.awt.*;

import java.io.IOException;
import java.util.List;

public class InterMng {
    private final JPanel _panel;

    public InterMng() {
        _panel = new JPanel();
        _panel.setLayout(null);
        _panel.setOpaque(false);
    }

    public void SetSize(int pWidth, int pHeight) {
        _panel.setSize(new Dimension(pWidth, pHeight));
    }

    public void SetPosition(int pX, int pY) {
        _panel.setBounds(pX, pY, _panel.getWidth(), _panel.getHeight());
    }

    private void AddToPanel(List<? extends PlaceableObject> pPlaceableObjects) {
        for (var obj : pPlaceableObjects) {
            JRadioButton radio = new JRadioButton();
            radio.setSize(new Dimension(Constants.PLANE_RADIO_BUTTON_WIDTH, Constants.PLANE_RADIO_BUTTON_HEIGHT));
            if (Constants.USE_BG_FOR_PLANES_AND_AIRPORTS) radio.setBackground(new Color(0x123456));
            else radio.setOpaque(false);
            radio.setHorizontalAlignment(SwingConstants.CENTER);
            radio.setVerticalAlignment(SwingConstants.CENTER);

            // setting icon
            ImageWrapper img;
            try {
                String filename = "";
                if (obj instanceof Plane) {
                    filename = "/plane2@icon.png";
                } else if (obj instanceof Airport) {
                    filename = "/airport@icon.png";
                }
                img = new ImageWrapper(Constants.RESOURCES_PATH + filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            img.Resize((int) ((double) Constants.PLANE_RADIO_BUTTON_WIDTH / 2 * 1.5), (int) ((double) Constants.PLANE_RADIO_BUTTON_HEIGHT / 2 * 1.5));
            if (obj instanceof Plane) img.Rotate(((Plane) obj).getTrue_track());
            radio.setIcon(new ImageIcon(img.GetCurrentImage()));

            // setting position
            int posX, posY;

            double lb, rb, tb, bb;
            if (Constants.USER_POLAND_S_MAP_BOUNDS) {
                lb = Constants.POLAND_THE_WESTERNMOST_POINT_LONGITUDE;
                rb = Constants.POLAND_THE_EASTERNMOST_POINT_LONGITUDE;
                tb = Constants.POLAND_THE_NORTHERNMOST_POINT_LATITUDE;
                bb = Constants.POLAND_THE_SOUTHERNMOST_POINT_LATITUDE;
            } else {
                lb = Constants.LEFT_BORDER_LONGITUDE;
                rb = Constants.RIGHT_BORDER_LONGITUDE;
                tb = Constants.TOP_BORDER_LATITUDE;
                bb = Constants.BOTTOM_BORDER_LATITUDE;
            }
            posX = (int) ((obj.GetLongitude() - lb) / (rb - lb) * _panel.getWidth());
            posY = (int) ((tb - obj.GetLatitude()) / (tb - bb) * _panel.getHeight());

            radio.setBounds(posX, posY, radio.getWidth(), radio.getHeight());

            _panel.add(radio);
        }
    }

    public void Apply(List<Plane> pPlanes, List<Airport> pAirports) {
        AddToPanel(pPlanes);
        AddToPanel(pAirports);
    }

    public JPanel GetPanel() {
        return _panel;
    }
}