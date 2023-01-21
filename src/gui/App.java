package gui;

import constants.ActionPerformed;
import constants.Constants;
import constants.PlainLayout;
import gui.dynamic.tmpName;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class App extends JFrame implements ActionListener {
    Container _contentPane;
    JPanel _navigationGroup;
    JPanel _planesGroup;

    ButtonsFormation _buttonsFormation;
    MapOrganiser _mapOrganiser;

    tmpName _tmp;
    Thread _thr;

    public App() {
        this.Initialise();
        this.StartUp();

        this.AddActionListenerToButtons();
        this.PlaceButtonsInNavigationGroup();

        this.ManageNavigationGroup();
        this.ManagePlanesGroup();
        this.ManageMap();
        this.ManageContentPane();

        _thr.start();
    }


    private void Initialise() {
        _contentPane = this.getContentPane();
        _navigationGroup = new JPanel();

        _buttonsFormation = new ButtonsFormation();
        _mapOrganiser = new MapOrganiser();

        _tmp = new tmpName();
        _thr = new Thread(_tmp);
    }

    private void StartUp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("JAVA Project");
        this.setResizable(false);
        this.setContentPane(_contentPane);
        ImageWrapper img;
        try {
            img = new ImageWrapper(Constants.RESOURCES_PATH + "/logo@icon.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        img.Resize(16, 16);
        this.setIconImage(img.GetCurrentImage());
    }

    private void AddActionListenerToButtons() {
        _buttonsFormation.AddOneActionListenerToAllButtons(this);
    }

    private void PlaceButtonsInNavigationGroup() {
        _buttonsFormation.AppendToOnePanelAllButtons(_navigationGroup);
    }

    private void ManageNavigationGroup() {
        _navigationGroup.setSize(new Dimension(Constants.BUTTON_WIDTH * 3, Constants.BUTTON_HEIGHT * 6));
        ComponentPlacement.PlaceComponentSmart(_navigationGroup, PlainLayout.RIGHT, PlainLayout.TOP);
        _navigationGroup.setLayout(null);
        _navigationGroup.setBackground(new Color(0, 0, 0, 0));

        _contentPane.add(_navigationGroup);
    }

    private void ManagePlanesGroup() {
        _contentPane.add(_planesGroup);
    }

    private void ManageMap() {
        _mapOrganiser.PinTo(_contentPane);
        _mapOrganiser.DrawMap();
    }

    private void ManageContentPane() {
        _contentPane.setBounds(0, 0, _contentPane.getWidth(), _contentPane.getHeight());
        _contentPane.setPreferredSize(new Dimension(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        _contentPane.setLayout(null);

        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ActionPerformed action = ActionPerformed.fromString(((JButton) actionEvent.getSource()).getName());

        switch (Objects.requireNonNull(action)) {
            case MOVE_TO_NORTH -> _mapOrganiser.MoveToNorthCalled();
            case MOVE_TO_SOUTH -> _mapOrganiser.MoveToSouthCalled();
            case MOVE_TO_WEST -> _mapOrganiser.MoveToWestCalled();
            case MOVE_TO_EAST -> _mapOrganiser.MoveToEastCalled();
            case RESET_POS -> _mapOrganiser.ResetPosCalled();
            case ZOOM_IN -> _mapOrganiser.ZoomInCalled();
            case ZOOM_OUT -> _mapOrganiser.ZoomOutCalled();
        }

        _mapOrganiser.DrawMap();
    }
}