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

            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "15.15", "45.45", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "16.16", "46.46", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "17.17", "47.47", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "18.18", "48.48", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "19.19", "49.49", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "20.20", "50.50", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "21.21", "51.51", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "22.22", "52.52", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "23.23", "53.53", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));
            result.add(new Plane(new String[]{"abc", "def", "ghi", "3", "4", "24.24", "54.54", "7.7", "true", "9.9", "10.10", "11.11", "ignore", "13.13", "as it is", "false", "16"}));

            return result;
        } else return Plane.get_newest_plane_list();
    }
}