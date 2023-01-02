import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;


public class Test {
    public static void main(String[] args) throws IOException {

        ArrayList<String[]> list_of_planes = get_data_about_planes_above_poland.refresh();
        for (String[] plane: list_of_planes) {
            System.out.println(Arrays.toString(plane));
        }
    }
}
