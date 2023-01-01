import opensky.api.OpenSkyApi;
import org.opensky.model.OpenSkyStates;
import org.opensky.model.StateVector;

import java.io.IOException;
import java.util.Collection;

public class Test {
    public static void main(String[] args) throws IOException {
        String username = API_credentials.username;
        String password = API_credentials.password;
        OpenSkyApi api = new OpenSkyApi(username, password);
        OpenSkyApi.BoundingBox box = new OpenSkyApi.BoundingBox(49.0273953314, 54.8515359564, 14.0745211117,24.0299857927);
        OpenSkyStates os = api.getStates(0, null, box);
        Collection<StateVector> planes_poland = os.getStates();
        System.out.println(planes_poland);
    }
}
