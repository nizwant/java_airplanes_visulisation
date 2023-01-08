package gui;

import constants.ActionPerformed;
import constants.Constants;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ButtonsFormation {
    JButton _moveToNorth;
    JButton _moveToSouth;
    JButton _moveToWest;
    JButton _moveToEast;

    JButton _resetPos;

    JButton _zoomIn;
    JButton _zoomOut;

    ArrayList<JButton> _allButtons;

    public ButtonsFormation() {
        this.Initialize();
        this.SetButtonsSizes();
        this.SetButtonsPositions();
        this.NameButtons();
        this.SetButtonsImages();
    }

    private void Initialize() {
        _moveToNorth = new JButton();
        _moveToSouth = new JButton();
        _moveToWest = new JButton();
        _moveToEast = new JButton();
        _resetPos = new JButton();
        _zoomIn = new JButton();
        _zoomOut = new JButton();

        _allButtons = new ArrayList<>();

        this.AddButtonsToList();
    }

    private void AddButtonsToList() {
        _allButtons.add(_moveToNorth);
        _allButtons.add(_moveToSouth);
        _allButtons.add(_moveToWest);
        _allButtons.add(_moveToEast);
        _allButtons.add(_resetPos);
        _allButtons.add(_zoomIn);
        _allButtons.add(_zoomOut);
    }

    private void SetButtonsSizes() {
        for (var button : _allButtons) {
            this.SetButtonSize(button);
        }
    }

    private void SetButtonSize(JButton pButton) {
        pButton.setBounds(pButton.getX(), pButton.getY(), Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
    }

    private void SetButtonsPositions() {
        _moveToNorth.setBounds(Constants.BUTTON_WIDTH, 0, _moveToNorth.getWidth(), _moveToNorth.getHeight());
        _moveToSouth.setBounds(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT * 2, _moveToSouth.getWidth(), _moveToSouth.getHeight());
        _moveToWest.setBounds(0, Constants.BUTTON_HEIGHT, _moveToWest.getWidth(), _moveToWest.getHeight());
        _moveToEast.setBounds(Constants.BUTTON_WIDTH * 2, Constants.BUTTON_HEIGHT, _moveToEast.getWidth(), _moveToEast.getHeight());
        _resetPos.setBounds(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT, _resetPos.getWidth(), _resetPos.getHeight());
        _zoomIn.setBounds(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT * 4, _zoomIn.getWidth(), _zoomIn.getHeight());
        _zoomOut.setBounds(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT * 5, _zoomOut.getWidth(), _zoomOut.getHeight());
    }

    private void NameButtons() {
        _moveToNorth.setName(ActionPerformed.MOVE_TO_NORTH.getValue());
        _moveToSouth.setName(ActionPerformed.MOVE_TO_SOUTH.getValue());
        _moveToWest.setName(ActionPerformed.MOVE_TO_WEST.getValue());
        _moveToEast.setName(ActionPerformed.MOVE_TO_EAST.getValue());
        _resetPos.setName(ActionPerformed.RESET_POS.getValue());
        _zoomIn.setName(ActionPerformed.ZOOM_IN.getValue());
        _zoomOut.setName(ActionPerformed.ZOOM_OUT.getValue());
    }

    private void SetButtonsImages() {
        this.SetButtonImage(_moveToNorth, "collapse-arrow.png");
        this.SetButtonImage(_moveToSouth, "expand-arrow.png");
        this.SetButtonImage(_moveToWest, "back.png");
        this.SetButtonImage(_moveToEast, "forward.png");
        this.SetButtonImage(_resetPos, "location-off.png");
        this.SetButtonImage(_zoomIn, "zoom-in.png");
        this.SetButtonImage(_zoomOut, "zoom-out.png");
    }

    private void SetButtonImage(JButton pButton, String pIconName) {
        ImageWrapper img;

        try {
            img = new ImageWrapper(Constants.RESOURCES_PATH + "/icons/" + pIconName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        img.Resize(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        pButton.setIcon(new ImageIcon(img.GetCurrentImage()));
    }

    public void AddOneActionListenerToAllButtons(ActionListener pActionListenerImpl) {
        for (var button : _allButtons) {
            button.addActionListener(pActionListenerImpl);
        }
    }

    public void AppendToOnePanelAllButtons(JPanel pComp) {
        for (var button : _allButtons) {
            pComp.add(button);
        }
    }
}