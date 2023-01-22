package planes;

import constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static List<Airport> GetAirports() {
        if (Constants.USE_TEST_DATA) {
            List<Airport> result = new ArrayList<>();

            result.add(new Airport(54.3775, 18.466389, "Gdańsk", "Port Lotniczy Gdańsk im. Lecha Wałęsy – międzynarodowy port lotniczy położony w gdańskiej dzielnicy Matarnia, pierwotnie nazywany Gdańsk Rębiechowo; położony 10 km od centrum Gdańska i Sopotu oraz 23 km od centrum Gdyni."));
            result.add(new Airport(50.474444, 19.08, "Katowice", "Port lotniczy Katowice-Pyrzowice - międzynarodowy port lotniczy położony w miejscowości Pyrzowice, około 33[3] kilometry na północ od centrum Katowic, w Górnośląsko-Zagłębiowskiej Metropolii."));
            result.add(new Airport(52.451111, 20.650833, "Warszawa Modlin", "Port Lotniczy Warszawa/Modlin – międzynarodowy port lotniczy w Nowym Dworze Mazowieckim, drugi dla aglomeracji warszawskiej, zlokalizowany około 35 km na północny zachód od granicy śródmieścia Warszawy."));
            result.add(new Airport(52.165833, 20.967222, "Warszawa Chopin", "Lotnisko Chopina w Warszawie – międzynarodowy port lotniczy znajdujący się w Warszawie. Został otwarty w 1934. Lotnisko Chopina jest położone na osiedlu Okęcie w dzielnicy Włochy, w odległości około 8 km na południowy zachód od centrum miasta."));
            result.add(new Airport(52.421111, 16.826389, "Poznań", "Port Lotniczy Poznań-Ławica im. Henryka Wieniawskiego – międzynarodowy port lotniczy, jedno z najstarszych lotnisk w Polsce, położone 7 km na zachód od centrum Poznania przy trasie na Berlin i Buk."));
            result.add(new Airport(50.11, 22.019167, "Rzeszów Jasionka", "Port lotniczy Rzeszów-Jasionka – międzynarodowy port lotniczy położony w województwie podkarpackim, 14 km od centrum Rzeszowa we wsi Jasionka. W 2017 roku z lotniska skorzystało 694 tys. pasażerów, co dało mu 7. miejsce w Polsce pod względem liczby obsłużonych pasażerów."));
            result.add(new Airport(51.102778, 16.886111, "Wrocław", "Port lotniczy Wrocław im. Mikołaja Kopernika. – międzynarodowy port lotniczy położony na terenie miasta Wrocławia, w odległości ok. 10 km na zachód od jego centrum, na osiedlu Strachowice."));
            result.add(new Airport(50.077778, 19.785, "Kraków", "Międzynarodowy Port Lotniczy im. Jana Pawła II Kraków-Balice – międzynarodowy port lotniczy położony 11 km na zachód od centrum Krakowa, w miejscowości Balice. Port lotniczy jest zlokalizowany obok 8 Bazy Lotnictwa Transportowego w Balicach."));

            return result;
        } else return Airport.get_airport_list();
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