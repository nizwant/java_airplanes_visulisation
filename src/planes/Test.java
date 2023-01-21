package planes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {
    public static void main(String[] args) throws IOException {

        ArrayList<String[]> list_of_planes = get_data_about_planes_above_poland.refresh();
        List<Plane> modified_list_of_planes= new ArrayList<>();

        for (String[] plane : list_of_planes) {

            System.out.println(Arrays.toString(plane));
            Plane modified_Plane=new Plane(plane);
            modified_list_of_planes.add(modified_Plane);
        }

        for (Plane modPlane: modified_list_of_planes)
        {
            System.out.println(modPlane);
            System.out.println(modPlane.getLatitude()+5);
            System.out.println(modPlane.getOrigin_country());
        }

    }
}