package planes;

import java.util.Arrays;

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
    private float geo_latitude;
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
//        this.baro_altitude=parseFloat(planeFeatures[7]);
//        this.on_ground=Boolean.parseBoolean(planeFeatures[8]);
        this.velocity = parseFloat(planeFeatures[9]);
        this.true_track = parseFloat(planeFeatures[10]);
//        this.vertical_rate=parseFloat(planeFeatures[11]);
//        this.sensors=null;
//        this.geo_altitude=parseFloat(planeFeatures[13]);
//        this.squawk=planeFeatures[14];
//        this.spi=Boolean.parseBoolean(planeFeatures[15]);
//        this.position_source=parseInt(planeFeatures[16]);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "icao24='" + icao24 + '\'' +
                ", callsign='" + callsign + '\'' +
                ", origin_country='" + origin_country + '\'' +
                ", time_position=" + time_position +
                ", last_contact=" + last_contact +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", baro_altitude=" + baro_altitude +
                ", on_ground=" + on_ground +
                ", velocity=" + velocity +
                ", true_track=" + true_track +
                ", vertical_rate=" + vertical_rate +
                ", sensors=" + Arrays.toString(sensors) +
                ", geo_altitude=" + geo_latitude +
                ", squawk='" + squawk + '\'' +
                ", spi=" + spi +
                ", position_source=" + position_source +
                '}';
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public int getTime_position() {
        return time_position;
    }

    public void setTime_position(int time_position) {
        this.time_position = time_position;
    }

    public int getLast_contact() {
        return last_contact;
    }

    public void setLast_contact(int last_contact) {
        this.last_contact = last_contact;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getBaro_altitude() {
        return baro_altitude;
    }

    public void setBaro_altitude(float baro_altitude) {
        this.baro_altitude = baro_altitude;
    }

    public boolean isOn_ground() {
        return on_ground;
    }

    public void setOn_ground(boolean on_ground) {
        this.on_ground = on_ground;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getTrue_track() {
        return true_track;
    }

    public void setTrue_track(float true_track) {
        this.true_track = true_track;
    }

    public float getVertical_rate() {
        return vertical_rate;
    }

    public void setVertical_rate(float vertical_rate) {
        this.vertical_rate = vertical_rate;
    }

    public int[] getSensors() {
        return sensors;
    }

    public void setSensors(int[] sensors) {
        this.sensors = sensors;
    }

    public float getGeo_latitude() {
        return geo_latitude;
    }

    public void setGeo_latitude(float geo_latitude) {
        this.geo_latitude = geo_latitude;
    }

    public String getSquawk() {
        return squawk;
    }

    public void setSquawk(String squawk) {
        this.squawk = squawk;
    }

    public boolean isSpi() {
        return spi;
    }

    public void setSpi(boolean spi) {
        this.spi = spi;
    }

    public int getPosition_source() {
        return position_source;
    }

    public void setPosition_source(int position_source) {
        this.position_source = position_source;
    }
}
