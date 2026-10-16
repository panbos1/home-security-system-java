package csd.uoc.gr.A21;

public class LaserSensor extends Sensor {
    private float range;

    public LaserSensor(String id, boolean on, boolean violation, float range) {
        super(id, on, violation);
        setRange(range);
    }

    public void setRange(float NewRange) {
        range = NewRange;
    }

    public float getRange() {
        return range;
    } // kanoume setters k getters gia tin float range

    public String toString() {
        return super.toString() + ", range = " + range + ", (laser sensor)"; // kanoume super gia na tiposoume apo sensor kai to extra apo laser

    }
}