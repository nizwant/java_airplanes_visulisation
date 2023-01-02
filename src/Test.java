import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;


public class Test {
    public static void main(String[] args) throws IOException {

        // http request
        URL url = new URL("https://opensky-network.org/api/states/all?lamin=49.0273953314&lomin=14.0745211117&lamax=54.8515359564&lomax=24.0299857927");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
        br.close();
        con.disconnect();

        // string operation
        String data_in_string = sb.toString();
        String sub_data = data_in_string.substring(29, data_in_string.length() - 3);
        String[] array_of_strings_with_planes = sub_data.split("],");
        for (String plane_str: array_of_strings_with_planes) {
            plane_str = plane_str.substring(1);
            String[] ss = plane_str.split(",");
            System.out.println(Arrays.toString(ss));
        }
    }
}
