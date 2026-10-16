package csd.uoc.gr.A24;


import csd.uoc.gr.A22.HomeSecuritySystem;

public class DoorMonitorThread extends Thread {
    private HomeSecuritySystem securitySystem;

    public DoorMonitorThread(HomeSecuritySystem securitySystem) {
        this.securitySystem = securitySystem;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(1000);

                if (!securitySystem.isDoorClosed()) {
                    securitySystem.triggerAlarm();
                }
            } catch (InterruptedException e) {
                // Το νήμα διακόπηκε
                break;
            }
        }
    }
}

