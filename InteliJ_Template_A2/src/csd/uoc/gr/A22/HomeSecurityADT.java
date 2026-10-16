package csd.uoc.gr.A22;


public abstract class HomeSecurityADT {

    public abstract String getSystemStatus();

    public abstract void arm(String password) throws InternalSensorViolationException, WrongPasswordException;

    public abstract void activateStayMode() throws ExternalSensorViolationException, NotDisarmedException;

    public abstract void disarm(String password) throws WrongPasswordException;

    public abstract void changePassword(String currentPassword, String newPassword) throws WrongPasswordException;
}
