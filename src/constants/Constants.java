package constants;

import java.awt.*;

public class Constants {
    public static int WINDOW_WIDTH = 900;
    public static int WINDOW_HEIGHT = 900;

    public static int BUTTON_WIDTH = 50;
    public static int BUTTON_HEIGHT = 50;

    public static double SCALE_BOOST = 50; // %
    public static int MAP_MOVE_STEP = 100; // flat
    public static int MAP_SCALING_ALGORITHM = Image.SCALE_FAST;
    public static double INIT_SCALE = 0.3534;
    public static int INIT_MAP_POS_X = 0;
    public static int INIT_MAP_POS_Y = 0;
    public static int ZOOM_IN_COUNT_LIMIT = 5;

    public static String RESOURCES_PATH = "./resources";
    public static String MAP_NAME = "satellite3.png";

    public static int REFRESH_DELAY_IN_SECONDS = 5;

    public static boolean USE_TEST_DATA = false;

    public static int INTERACTABLE_OBJECT_BUTTON_WIDTH = 50;
    public static int INTERACTABLE_OBJECT_BUTTON_HEIGHT = 50;
    public static boolean USE_BG_FOR_PLANES_AND_AIRPORTS = false;

    public static double POLAND_THE_WESTERNMOST_POINT_LONGITUDE = 13.632292;
    public static double POLAND_THE_EASTERNMOST_POINT_LONGITUDE = 24.520718;
    public static double POLAND_THE_NORTHERNMOST_POINT_LATITUDE = 55.249618;
    public static double POLAND_THE_SOUTHERNMOST_POINT_LATITUDE = 48.760368;

    public static double LEFT_BORDER_LONGITUDE = -180;
    public static double RIGHT_BORDER_LONGITUDE = 180;
    public static double TOP_BORDER_LATITUDE = 90;
    public static double BOTTOM_BORDER_LATITUDE = -90;

    public static boolean USER_POLAND_S_MAP_BOUNDS = true;
}