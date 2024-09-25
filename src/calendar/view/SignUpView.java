package calendar.view;

import calendar.controller.SignUpController;

import javax.swing.*;
import java.awt.*;

public class SignUpView {
    private SignUpController signUpController;

    public SignUpView(SignUpController signUpController) {
        this.signUpController = signUpController;
    }

    public void createSignUpView() {
        JFrame frame = new JFrame("Sign Up");
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField idField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField nameField = new JTextField();
        JButton signUpButton = new JButton("Sign Up");

        panel.add(new JLabel("User ID:"));
        panel.add(idField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(signUpButton);

        frame.add(panel);
        frame.setSize(400, 200); // 프레임 크기 설정
        frame.setLocationRelativeTo(null); // 화면 중앙에 위치
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 설정
        frame.setVisible(true);

        signUpButton.addActionListener(e -> {
            String userId = idField.getText();
            String password = new String(passwordField.getPassword());
            String name = nameField.getText();
            // 회원가입 로직 실행 (컨트롤러에서 처리)
            JOptionPane.showMessageDialog(frame, "Sign Up successful!");
            frame.dispose();  // 회원가입 후 화면 종료
        });
    }
}
