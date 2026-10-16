package csd.uoc.gr.A21;

public class Sensor {
    private String id; // orizoume to string id to boolean on kai to violation se private opos mas zitite
    private boolean on;
    private boolean violation;

    public Sensor(String id, boolean on, boolean violation) {  //ta arxikopoioume
        this.on = on;
        this.id = id;
        this.violation = violation;
    }

    public void setId(String NewId) {
        id = NewId;
    }  //kanoume ta katallila setters

    public void setOn(boolean NewOn) {
        on = NewOn;
    }

    public void setViolation(boolean NewViolation) {
        violation = NewViolation;
    }

    public String getId() {  // kai antistoixws getters
        return id;
    }

    public boolean getOn() {
        return on;
    }

    public boolean getViolation() {
        return violation;
    }

    public String toString() {
        return "Sensor with id=" + id + ", On state =" + on + ", Violation state =" + violation; //tiponoume me to toString
    }
}


