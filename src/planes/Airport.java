package planes;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Airport extends PlaceableObject {

    private double longitude;
    private double latitude;
    private String name;

    public Airport(double latitude, double longitude, String name) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
    }


    public static List<Airport> get_airport_list() {
        List<Airport> list_of_airports = new ArrayList<>();

        list_of_airports.add(new Airport(54.3775, 18.466389, "Gdańsk"));
        list_of_airports.add(new Airport(50.474444, 19.08, "Katowice"));
        list_of_airports.add(new Airport(52.451111, 20.650833, "Warszawa Modlin"));
        list_of_airports.add(new Airport(52.165833, 20.967222, "Warszawa Chopin"));
        list_of_airports.add(new Airport(52.421111, 16.826389, "Poznań"));
        list_of_airports.add(new Airport(50.11, 22.019167, "Rzeszów Jasionka"));
        list_of_airports.add(new Airport(51.102778, 16.886111, "Wrocław"));
        list_of_airports.add(new Airport(50.077778, 19.785, "Kraków"));

        return list_of_airports;
    }


    @Override
    public double GetLongitude() {
        return longitude;
    }


    @Override
    public double GetLatitude() {
        return latitude;
    }

    public String GetName() {
        return name;
    }

}
