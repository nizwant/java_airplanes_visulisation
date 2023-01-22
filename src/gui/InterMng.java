package gui;

import constants.Constants;
import gui.interactable.InteractableObject;
import planes.Airport;
import planes.PlaceableObject;
import planes.Plane;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Color;

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
            InteractableObject btn = new InteractableObject(obj);

            btn.setSize(new Dimension(Constants.INTERACTABLE_OBJECT_BUTTON_WIDTH, Constants.INTERACTABLE_OBJECT_BUTTON_HEIGHT));
            if (Constants.USE_BG_FOR_PLANES_AND_AIRPORTS) btn.setBackground(new Color(0x123456));
            else btn.setOpaque(false);
            btn.setHorizontalAlignment(SwingConstants.CENTER);
            btn.setVerticalAlignment(SwingConstants.CENTER);

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
            img.Resize((int) ((double) Constants.INTERACTABLE_OBJECT_BUTTON_WIDTH / 2 * 1.5), (int) ((double) Constants.INTERACTABLE_OBJECT_BUTTON_HEIGHT / 2 * 1.5));
            if (obj instanceof Plane) img.Rotate(((Plane) obj).getTrue_track());
            btn.setIcon(new ImageIcon(img.GetCurrentImage()));

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

            btn.setBounds(posX, posY, btn.getWidth(), btn.getHeight());

            btn.addActionListener(InteractableObject::ProcessEvent);

            _panel.add(btn);
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