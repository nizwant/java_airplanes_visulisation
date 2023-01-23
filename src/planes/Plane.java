package planes;

import constants.Constants;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Plane extends PlaceableObject {
    private String icao24;
    private String callsign;
    private String origin_country;
    private int time_position;
    private int last_contact;
    private float longitude;
    private float latitude;
    private String baro_altitude;
    private String on_ground;
    private String velocity;
    private float true_track;
    private String vertical_rate;
    private int[] sensors;
    private float geo_altitude;
    private String squawk;
    private boolean spi;
    private int position_source;

    public Plane(String[] planeFeatures) {
        this.icao24 = planeFeatures[0].substring(1, planeFeatures[0].length() - 1);
        this.callsign = planeFeatures[1].substring(1, planeFeatures[1].length() - 1).trim();
        this.origin_country = planeFeatures[2].substring(1, planeFeatures[2].length() - 1);
        this.time_position = parseInt(planeFeatures[3]);
        this.last_contact = parseInt(planeFeatures[4]);
        this.longitude = parseFloat(planeFeatures[5]);
        this.latitude = parseFloat(planeFeatures[6]);
        this.baro_altitude = planeFeatures[7];
        this.on_ground = planeFeatures[8];
        this.velocity = planeFeatures[9];
        this.true_track = parseFloat(planeFeatures[10]);
        this.vertical_rate = planeFeatures[11];
//        this.sensors=null;
//        this.geo_altitude=parseFloat(planeFeatures[13]);
        this.squawk = planeFeatures[14];
//        this.spi=Boolean.parseBoolean(planeFeatures[15]);
//        this.position_source=parseInt(planeFeatures[16]);
    }

    public static List<Plane> get_newest_plane_list() {
        ArrayList<String[]> list_of_planes;
        try {
            list_of_planes = get_data_about_planes_above_poland.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Plane> modified_list_of_planes = new ArrayList<>();

        for (String[] plane : list_of_planes) {
            Plane modified_Plane = new Plane(plane);
            modified_list_of_planes.add(modified_Plane);
        }

        return modified_list_of_planes;
    }

    @Override
    public String toString() {
        return "Plane{" + "icao24='" + icao24 + '\'' + ", callsign='" + callsign + '\'' + ", origin_country='" + origin_country + '\'' + ", time_position=" + time_position + ", last_contact=" + last_contact + ", longitude=" + longitude + ", latitude=" + latitude + ", baro_altitude=" + baro_altitude + ", on_ground=" + on_ground + ", velocity=" + velocity + ", true_track=" + true_track + ", vertical_rate=" + vertical_rate + ", sensors=" + Arrays.toString(sensors) + ", geo_altitude=" + geo_altitude + ", squawk='" + squawk + '\'' + ", spi=" + spi + ", position_source=" + position_source + '}';
    }

    public String getIcao24() {
        return icao24;
    }

    public String getCallsign() {
        return callsign;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public int getTime_position() {
        return time_position;
    }

    public int getLast_contact() {
        return last_contact;
    }

    @Override
    public double GetLongitude() {
        return longitude;
    }

    @Override
    public double GetLatitude() {
        return latitude;
    }

    @Override
    public String GetName() {
        return icao24;
    }

    @Override
    public String GetDataBeautified() {
        String callsign_mess;
        String origin_country_mess;
        String on_ground_mess;
        String baro_altitude_mess;
        String vertical_rate_mess;
        String velocity_mess;
        String squawk_mess;

        if (Objects.equals(callsign, "")) {
            callsign_mess = "Samolot specjalny, dla bezpieczeństwa nie jest podane jak zwraca się do mnie wieża";
        } else {
            callsign_mess = "Wieża kontrolna zwraca się do mnie " + callsign;
        }

        CountryCodes pom = new CountryCodes();
        origin_country_mess = ", kraj mojego pochodzenia to " + pom.getCode(origin_country);

        if (Objects.equals(on_ground, "null")) {
            on_ground_mess = "";
        } else if (Objects.equals(on_ground, "true")) {
            on_ground_mess = ", obecnie znajduje się na ziemii";
        } else {
            on_ground_mess = ", jestem w powietrzu";
        }

        if (Objects.equals(baro_altitude, "null")) {
            baro_altitude_mess = "";

        }else {
            baro_altitude_mess = ", na wysokości " + (Math.abs(parseFloat(baro_altitude))) + " metrów";
        }

        if (Objects.equals(vertical_rate, "null")) {
            vertical_rate_mess = "";
        } else if (Objects.equals(vertical_rate, "0")) {
            vertical_rate_mess = ", nie wznoszę się ani nie opadam";
        } else if (parseFloat(vertical_rate) > 0) {
            vertical_rate_mess = ", wznoszę się z prędkością " + vertical_rate + " metrów na sekunde";
        } else {
            vertical_rate_mess = ", opadam z prędkością " + (-parseFloat(vertical_rate)) + " metrów na sekunde";
        }

        if (Objects.equals(velocity, "null")) {
            velocity_mess = "";
        } else if (parseFloat(velocity) == 0) {
            velocity_mess = ", aktualnie stoję w miejscu, nigdzie się nie ruszam";
        } else {
            velocity_mess = ", poruszam się z prędkością " + velocity + " metrów na sekunde";
        }

        if (Objects.equals(squawk, "null")) {
            squawk_mess = "";
        } else {
            squawk_mess = ", do porozumiewania się z ziemią używam kanału o numerze " + squawk;
        }


        return callsign_mess + origin_country_mess + on_ground_mess + baro_altitude_mess + vertical_rate_mess + velocity_mess + squawk_mess;
    }


    public float getTrue_track() {
        if (Constants.USE_TEST_DATA) return (float) ThreadLocalRandom.current().nextInt(0, 360 + 1);
        else return true_track;
    }


    public int[] getSensors() {
        return sensors;
    }

    public float getGeo_altitude() {
        return geo_altitude;
    }

    public String getSquawk() {
        return squawk;
    }

    public boolean isSpi() {
        return spi;
    }

    public int getPosition_source() {
        return position_source;
    }
}