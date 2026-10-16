package csd.uoc.gr.A21;

import csd.uoc.gr.A21.Sensor;
import csd.uoc.gr.A21.SensorLine;

public class SensorTester {
    public static void main(String[] args) {
        SensorLine sensorLine = new SensorLine();

        for (int i = 0; i < 100; i++) {
            Sensor sensor;
            String id = "SID" + i;
            boolean violation = i % 4 == 0; // kath 4os aisthitira violated

            if (i % 3 == 0) {
                sensor = new TemperatureSensor(id, violation, true);
            } else if (i % 3 == 1) {
                float range = i;
                sensor = new LaserSensor(id, violation, true, range);
            } else {
                sensor = new Sensor(id, violation, true);
            }

            sensorLine.add(sensor);
        }

        System.out.println(sensorLine.toString());
    }
}
