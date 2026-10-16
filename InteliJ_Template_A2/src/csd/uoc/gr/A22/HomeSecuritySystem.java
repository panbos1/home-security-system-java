package csd.uoc.gr.A22;
import csd.uoc.gr.A21.Sensor;
import csd.uoc.gr.A21.SensorLine;
public class HomeSecuritySystem extends HomeSecurityADT {

    private boolean isArmed;
    private boolean stayModeActivated;
    private String password;
    private SensorLine internalSensors;
    private SensorLine externalSensors;

    public HomeSecuritySystem(SensorLine internalSensors, SensorLine externalSensors) {
        this.isArmed = false;
        this.stayModeActivated = false;
        this.password = "1111"; // Default password
        this.internalSensors = internalSensors;
        this.externalSensors = externalSensors;
    }

    public HomeSecuritySystem() {

    }

    public boolean isArmed() {
        return isArmed;
    }

    public boolean isStayModeActivated() {
        return stayModeActivated;
    }

    @Override
    public String getSystemStatus() {
        return null;
    }

    public void arm(String password) throws InternalSensorViolationException, WrongPasswordException {
        if (isArmed) {
            return; // Already armed
        }

        if (internalSensors.isViolated()) {
            throw new InternalSensorViolationException();
        }

        if (password.equals(this.password)) {
            isArmed = true;
        } else {
            throw new WrongPasswordException("Wrong password");
        }
    }

    public void disarm(String password) throws WrongPasswordException {
        if (password.equals(this.password)) {
            isArmed = false;
        } else {
            throw new WrongPasswordException("Wrong password");
        }
    }

    public void changePassword(String currentPassword, String newPassword) throws WrongPasswordException {
        if (currentPassword.equals(this.password)) {
            this.password = newPassword;
        } else {
            throw new WrongPasswordException("Wrong password");
        }
    }

    public void activateStayMode() throws ExternalSensorViolationException, NotDisarmedException {
        if (!isArmed) {
            throw new NotDisarmedException("System is not disarmed");
        }

        if (externalSensors.isViolated()) {
            throw new ExternalSensorViolationException();
        }

        internalSensors.setOn(false);
        stayModeActivated = true;
    }

    public boolean isDoorClosed() {

        for (Sensor sensor : internalSensors.getSensors()) {
            if (sensor.getId().equals("doorSensor")) {
                return sensor.getOn();
            }
        }
        return false;
    }


    public void triggerAlarm() {
        if (isArmed && isDoorClosed()) {
            System.out.println("Alarm triggered: Door is open!");

        }
    }
}
