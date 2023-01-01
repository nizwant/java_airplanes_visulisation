import org.opensky.api.OpenSkyApi;
import org.opensky.model.OpenSkyStates;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String username = API_credentials.username;
        String password = API_credentials.password;
        System.out.println(username);
        System.out.println(password);
        OpenSkyApi api = new OpenSkyApi(username, password);
        OpenSkyStates os = api.getStates(0, null, null);
        System.out.println(os.getStates());
    }
}
