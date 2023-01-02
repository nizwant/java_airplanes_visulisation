import java.util.ArrayList;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Plane {
    private String icao24;
    private String callsign;
    private String origin_country;
    private int time_position;
    private int last_contact;
    private float longitude;
    private float latitude;
    private float baro_altitude;
    private boolean on_ground;
    private float velocity;
    private float true_track;
    private float vertical_rate;
    private int[] sensors;
    private float geo_altitude;
    private String squawk;
    private boolean spi;
    private int position_source;

    public Plane(ArrayList<String> planeFeatures){
        this.icao24= planeFeatures.get(0);
        this.callsign= planeFeatures.get(1);
        this.origin_country=planeFeatures.get(2);
        this.time_position=parseInt(planeFeatures.get(3));
        this.last_contact=parseInt(planeFeatures.get(4));
        this.longitude=parseFloat(planeFeatures.get(5));
        this.latitude=parseFloat(planeFeatures.get(6));
        this.baro_altitude=parseFloat(planeFeatures.get(7));
        this.on_ground=Boolean.parseBoolean(planeFeatures.get(8));
        this.velocity=parseFloat(planeFeatures.get(9));
        this.true_track=parseFloat(planeFeatures.get(10));
        this.vertical_rate=parseFloat(planeFeatures.get(11));
        this.sensors=null;
        this.geo_altitude=parseFloat(planeFeatures.get(13));
        this.squawk=planeFeatures.get(14);
        this.spi=Boolean.parseBoolean(planeFeatures.get(15));
        this.position_source=parseInt(planeFeatures.get(16));
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

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getBaro_altitude() {
        return baro_altitude;
    }

    public boolean isOn_ground() {
        return on_ground;
    }

    public float getVelocity() {
        return velocity;
    }

    public float getTrue_track() {
        return true_track;
    }

    public float getVertical_rate() {
        return vertical_rate;
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
