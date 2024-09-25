package calendar.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpView {
    private JFrame frame;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JButton signUpButton;
    private JButton cancelButton;

    public SignUpView() {
        createSignUpView();
    }

    public void createSignUpView() {
        frame = new JFrame("Sign Up");
        JPanel panel = new JPanel(new GridLayout(4, 2));

        userIdField = new JTextField();
        passwordField = new JPasswordField();
        nameField = new JTextField();
        signUpButton = new JButton("Sign Up");
        cancelButton = new JButton("Cancel");

        panel.add(new JLabel("User ID:"));
        panel.add(userIdField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(signUpButton);
        panel.add(cancelButton);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 리스너 설정
    public void setSignUpButtonListener(ActionListener listener) {
        signUpButton.addActionListener(listener);
    }

    public void setCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    public String getUserId() {
        return userIdField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getName() {
        return nameField.getText();
    }

    public JFrame getFrame() {
        return frame;
    }
}