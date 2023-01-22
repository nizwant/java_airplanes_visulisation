package planes;
import java.io.IOException;
import constants.Constants;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Airport> GetAirports() {
        return Airport.get_airport_list();
    }

    public static List<Plane> GetPlanes() {
        if (Constants.USE_TEST_DATA) {
            List<Plane> result = new ArrayList<>();

            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "5.5", "6.6", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));

            return result;
        } else return Plane.get_newest_plane_list();
    }
}