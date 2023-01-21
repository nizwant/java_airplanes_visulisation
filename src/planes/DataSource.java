package planes;
import java.io.IOException;
import java.util.List;

public class DataSource {

    public List<Plane> GetPlanes() throws IOException {
        return Plane.get_newest_plane_list();
    }

    public static List<Airport> GetAirports() {
        return Airport.get_airport_list();
    }
}