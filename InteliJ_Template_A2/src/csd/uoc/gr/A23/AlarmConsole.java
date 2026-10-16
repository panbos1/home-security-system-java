package csd.uoc.gr.A23;

import csd.uoc.gr.A22.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlarmConsole {
    private JFrame frame;
    private JButton armButton;
    private JButton stayButton;
    private JButton disarmButton;
    private JButton changePasswordButton;
    private JTextField passwordField;
    private JTextArea outputArea;

    private HomeSecuritySystem securitySystem;

    public AlarmConsole() {
        initialize();
        this.securitySystem = new HomeSecuritySystem();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        armButton = new JButton("Arm");
        armButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    securitySystem.arm(passwordField.getText());
                    outputArea.append("System armed.\n");
                } catch (InternalSensorViolationException | WrongPasswordException ex) {
                    outputArea.append("Error arming system: " + ex.getMessage() + "\n");
                }
            }
        });
        armButton.setBounds(35, 34, 117, 29);
        frame.getContentPane().add(armButton);

        stayButton = new JButton("Stay");
        stayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    securitySystem.activateStayMode();
                    outputArea.append("Stay mode activated.\n");
                } catch (ExternalSensorViolationException | NotDisarmedException ex) {
                    outputArea.append("Error activating stay mode: " + ex.getMessage() + "\n");
                }
            }
        });
        stayButton.setBounds(35, 75, 117, 29);
        frame.getContentPane().add(stayButton);

        disarmButton = new JButton("Disarm");
        disarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    securitySystem.disarm(passwordField.getText());
                    outputArea.append("System disarmed.\n");
                } catch (WrongPasswordException ex) {
                    outputArea.append("Error disarming system: " + ex.getMessage() + "\n");
                }
            }
        });
        disarmButton.setBounds(35, 116, 117, 29);
        frame.getContentPane().add(disarmButton);

        changePasswordButton = new JButton("Change Password");
        changePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentPassword = JOptionPane.showInputDialog(frame, "Enter current password:");
                String newPassword = JOptionPane.showInputDialog(frame, "Enter new password:");
                try {
                    securitySystem.changePassword(currentPassword, newPassword);
                    outputArea.append("Password changed successfully.\n");
                } catch (WrongPasswordException ex) {
                    outputArea.append("Error changing password: " + ex.getMessage() + "\n");
                }
            }
        });
        changePasswordButton.setBounds(35, 157, 177, 29);
        frame.getContentPane().add(changePasswordButton);

        passwordField = new JTextField();
        passwordField.setBounds(220, 117, 134, 26);
        frame.getContentPane().add(passwordField);
        passwordField.setColumns(10);

        outputArea = new JTextArea();
        outputArea.setBounds(35, 198, 319, 54);
        frame.getContentPane().add(outputArea);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AlarmConsole();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
