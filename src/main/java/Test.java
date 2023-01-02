import org.opensky.model.StateVector;

import java.io.IOException;
import java.util.Collection;

public class Test {
    public static void main(String[] args) throws IOException {

        Collection<StateVector> planes_poland = Get_api_data.refreh();
        for (StateVector s:planes_poland) {
            System.out.println(s);
        }
    }
}
