package calendar.view;

import calendar.controller.LoginController;
import calendar.controller.SignUpController;

import javax.swing.*;
import java.awt.*;
public class LoginView {
    private LoginController loginController;
    private SignUpController signUpController;

    public LoginView(LoginController loginController, SignUpController signUpController) {
        this.loginController = loginController;
        this.signUpController = signUpController;
        createLoginView();
    }


    public void createLoginView() {
        JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel(new GridLayout(4, 2));

        // 사용자 입력 필드
        JTextField idField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");

        panel.add(new JLabel("User ID:"));
        panel.add(idField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signUpButton);

        frame.add(panel);
        frame.setSize(400, 200); // 프레임 크기 설정
        frame.setLocationRelativeTo(null); // 화면 중앙에 위치
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 설정
        frame.setVisible(true);

        // 로그인 버튼 액션
        loginButton.addActionListener(e -> {
            String userId = idField.getText();
            String password = new String(passwordField.getPassword());
            loginController.handleLogin(userId, password);
        });

        // 회원가입 버튼 액션
        signUpButton.addActionListener(e -> {
            signUpController.showSignUpView(); // 회원가입 화면으로 이동
        });
    }
}
