package csd.uoc.gr.A22;
import csd.uoc.gr.A21.SensorLine;



public class HomeSecurityTest {
    public static void main(String[] args) {
        // Δημιουργία αισθητήρων
        SensorLine internalSensors = new SensorLine();
        SensorLine externalSensors = new SensorLine();


        HomeSecuritySystem securitySystem = new HomeSecuritySystem(internalSensors, externalSensors);

        try {

            securitySystem.arm("1111");


            securitySystem.activateStayMode();


            securitySystem.changePassword("1111", "1234");


            securitySystem.disarm("1234");
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        } catch (InternalSensorViolationException e) {
            e.printStackTrace();
        } catch (ExternalSensorViolationException e) {
            e.printStackTrace();
        } catch (NotDisarmedException e) {
            e.printStackTrace();
        }
    }
}

