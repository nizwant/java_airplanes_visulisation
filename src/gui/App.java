package gui;

import constants.ActionPerformed;
import constants.Constants;
import constants.PlainLayout;
import gui.dynamic.DynamicPlacement;
import planes.Airport;
import planes.DataSource;
import planes.Plane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class App extends JFrame implements ActionListener {
    Container _contentPane;

    ButtonsFormation _buttonsFormation;
    JPanel _navigationGroup;

    MapOrganiser _mapOrganiser;

    List<Plane> _planes;
    List<Airport> _airports;

    DynamicPlacement _dPlacement;
    Thread _thr;

    public App() {
        this.Initialise();
        this.StartUp();

        this.AddActionListenerToButtons();
        this.PlaceButtonsInNavigationGroup();

        this.ManageNavigationGroup();
        this.ManageMap();
        this.ManageContentPane();

        _mapOrganiser.DrawMap();
        _thr.start();
    }

    private void Initialise() {
        _contentPane = this.getContentPane();
        _navigationGroup = new JPanel();

        _buttonsFormation = new ButtonsFormation();
        _mapOrganiser = new MapOrganiser();

        this.LoadPlanes();
        this.LoadAirports();

        _dPlacement = new DynamicPlacement(this);
        _thr = new Thread(_dPlacement);
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
        _navigationGroup.setBackground(Constants.TRANSPARENT);

        _navigationGroup.setName("NAVIGATION_GROUP");

        _contentPane.add(_navigationGroup);
    }

    private void ManageMap() {
        _mapOrganiser.PinTo(_contentPane);
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
        this.Refresh();
    }

    public void LoadPlanes() {
        _planes = DataSource.GetPlanes();
    }

    public void LoadAirports() {
        _airports = DataSource.GetAirports();
    }

    public void Refresh() {
        InterMng interactiveManager = new InterMng();

        interactiveManager.SetSize(_mapOrganiser.GetCurrentMapWidth(), _mapOrganiser.GetCurrentMapHeight());
        interactiveManager.SetPosition(_mapOrganiser.GetMapXPos(), _mapOrganiser.GetMapYPos());
        interactiveManager.Apply(_planes, _airports);

        JPanel planesAndAirportsPanel = interactiveManager.GetPanel();
        planesAndAirportsPanel.setName("PLANES_AND_AIRPORTS_PANEL");

        Component[] components = _contentPane.getComponents();
        for (int i = 0; i < components.length; i++) {
            if ("PLANES_AND_AIRPORTS_PANEL".equals(components[i].getName())) {
                _contentPane.remove(i);
            }
        }

        _contentPane.add(planesAndAirportsPanel);

        components = _contentPane.getComponents();
        for (Component component : components) {
            if ("PLANES_AND_AIRPORTS_PANEL".equals(component.getName())) {
                _contentPane.setComponentZOrder(component, 1);
            } else if ("MAP".equals(component.getName())) {
                _contentPane.setComponentZOrder(component, 2);
            } else if ("NAVIGATION_GROUP".equals(component.getName())) {
                _contentPane.setComponentZOrder(component, 0);
            }
        }

        _contentPane.repaint();
    }
}