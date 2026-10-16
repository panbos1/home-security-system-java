package csd.uoc.gr.A21;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor(String id, boolean on, boolean violation) { // arxikopoioume
        super(id, on, violation);
    }
    public  String toString(){
        return super.toString() + " ( temp. sensor "; // kanoume super return na erthoun oi times apo sensor kai na tiposoume kai to extra
    }
}