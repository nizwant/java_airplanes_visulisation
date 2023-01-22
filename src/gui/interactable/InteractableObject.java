package gui.interactable;

import constants.Constants;
import gui.ImageWrapper;
import planes.Airport;
import planes.PlaceableObject;
import planes.Plane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.io.IOException;

public class InteractableObject extends JButton {
    private PlaceableObject _data;

    public InteractableObject(PlaceableObject pData) {
        this._data = pData;
    }

    public static void ProcessEvent(ActionEvent e) {
        if (!(e.getSource() instanceof InteractableObject src))
            throw new RuntimeException("Event called with wrong parameters");

        // create new frame
        JFrame frame = new JFrame();
        // make close only this frame, but not whole application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // make it visible
        frame.setVisible(true);
        // set title depending on type of browsing object
        String name = "Info about ";
        if (src._data instanceof Plane) name += "plane";
        else if (src._data instanceof Airport) name += "airport";
        frame.setTitle(name + " #");
        // forbid resize
        frame.setResizable(false);

        // get content pane reference
        var contentPane = frame.getContentPane();
        // set its size
        contentPane.setPreferredSize(new Dimension(200, 300));
        // set its position
        contentPane.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());

        // create label
        JLabel label = new JLabel();
        // set inner text
        label.setText(src._data.toString());

        // add text to content pane
        contentPane.add(label);

        // pack frame
        frame.pack();
    }
}