package csd.uoc.gr.A21;

public class SensorLine {
    private String name;
    private Sensor[] sensors;
    private int activeCapacity ;

    public SensorLine(String name){
        this.name= name;
        this.sensors= new Sensor[1000]; //arxikopoioume to name ton pinaka 100 thesewn kai to capacity me 0 wste na auksaneteai kata 1 otan gemizei
        this.activeCapacity= 0;

    }

    public SensorLine() {
        this("Anonymous sensorLine");  //gia to default onoma
    }
    public void add(Sensor s) {
        if (activeCapacity < sensors.length) {      //gia na prosthetei ston pinaka me basei ton sensor s
            sensors[activeCapacity] = s;
            activeCapacity++;
        }
    }
    public void setOn(boolean on) {
        for(int i=0;i<activeCapacity;i++) { // anoigma/klisimo twn sensors
            sensors[i].setOn(on);
        }
    }

    public boolean isViolated() {
        for (int i=0;i<activeCapacity;i++) {  //epistrefei false an dn exei ginei violated kapoios sensor alliws true an egine violated
            if (sensors[i].getViolation()) {
                return true;
            }
        }
        return false;
    }
    public Sensor[] getSensors() {
        Sensor[] realSensors = new Sensor[activeCapacity]; // dimiourgoume tin getsensor
        System.arraycopy(sensors, 0, realSensors, 0, activeCapacity);
        return realSensors;
    }
    public String toString() {
        int numSensors= activeCapacity;
        boolean violated = isViolated();
        int numViolatedon=0;
        StringBuilder IdsofViolated= new StringBuilder();
        for(Sensor sensor : sensors){
            if( sensor != null && sensor.getViolation()&& sensor.getOn()){ //edw epanalambanete elegxos sta sensors k elegxei an kathe sensor den einai 0 kai an einai violated i on  an ola ayta einai ok mpainei sto Ids
                IdsofViolated.append(sensor.getId()).append(" ");
            }
        }
        return name + "\n"+ "Number of sensors="+ numSensors+"\n"+ "Violated="+violated+"\n"+ "# of violated sensors="+ numViolatedon+"\n"+"Ids of Violated: "+IdsofViolated;


    }
}
