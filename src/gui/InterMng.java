package gui;

import constants.Constants;
import planes.Airport;
import planes.PlaceableObject;
import planes.Plane;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Dimension;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InterMng {
    private final JPanel _panel;

    public InterMng() {
        _panel = new JPanel();
        _panel.setLayout(null);
        _panel.setBackground(Constants.TRANSPARENT);
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
            radio.setBackground(Constants.TRANSPARENT);

            int posX, posY;
            if (Constants.USE_TEST_DATA) {
                posX = ThreadLocalRandom.current().nextInt(0, Constants.WINDOW_WIDTH - Constants.PLANE_RADIO_BUTTON_WIDTH + 1);
                posY = ThreadLocalRandom.current().nextInt(0, Constants.WINDOW_HEIGHT - Constants.PLANE_RADIO_BUTTON_HEIGHT + 1);
            } else {
                posX = (int) ((obj.GetLongitude() - Constants.LEFT_BORDER_LONGITUDE) / (Constants.RIGHT_BORDER_LONGITUDE - Constants.LEFT_BORDER_LONGITUDE) * _panel.getWidth());
                posY = (int) ((Constants.TOP_BORDER_LATITUDE - obj.GetLatitude()) / (Constants.TOP_BORDER_LATITUDE - Constants.BOTTOM_BORDER_LATITUDE) * _panel.getHeight());
            }
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