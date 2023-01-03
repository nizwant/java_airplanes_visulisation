package gui;

import constants.Constants;
import constants.PlainLayout;

import java.awt.*;

public class ComponentPlacement {
    public static void PlaceComponentSmart(Component pComp, PlainLayout pHorAlign, PlainLayout pVerAlign) {
        int xPos = pComp.getX();
        int yPos = pComp.getY();

        switch (pHorAlign) {
            case LEFT, TOP -> xPos = 0;
            case CENTER, MIDDLE ->
                    xPos = (int) (((double) Constants.WINDOW_WIDTH) / 2 - ((double) pComp.getWidth()) / 2);
            case RIGHT, BOTTOM -> xPos = Constants.WINDOW_WIDTH - pComp.getWidth();
        }

        switch (pVerAlign) {
            case TOP, LEFT -> yPos = 0;
            case MIDDLE, CENTER ->
                    yPos = (int) (((double) Constants.WINDOW_HEIGHT) / 2 - ((double) pComp.getHeight()) / 2);
            case BOTTOM, RIGHT -> yPos = Constants.WINDOW_HEIGHT - pComp.getHeight();
        }

        ComponentPlacement.PlaceComponentCustom(pComp, xPos, yPos);
    }

    public static void PlaceComponentCustom(Component pComp, int pX, int pY) {
        pComp.setBounds(pX, pY, pComp.getWidth(), pComp.getHeight());
    }
}