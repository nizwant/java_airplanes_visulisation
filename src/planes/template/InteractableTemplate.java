package planes.template;

public class InteractableTemplate {
    protected double _longitude;
    protected double _latitude;

    public InteractableTemplate() {
        _longitude = 0.0;
        _latitude = 0.0;
    }

    public double GetLongitude() {
        return _longitude;
    }

    public double GetLatitude() {
        return _latitude;
    }
}