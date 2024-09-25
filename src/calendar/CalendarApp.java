package calendar;

import calendar.controller.LoginController;
import calendar.controller.SignUpController;
import calendar.service.MemberService;
import calendar.view.LoginView;

import java.sql.Connection;
import java.sql.DriverManager;

public class CalendarApp {
    public static void main(String[] args) {
        // 데이터베이스 연결 설정
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app_calendar", "na", "1234");

            MemberService memberService = new MemberService(connection);
            LoginController loginController = new LoginController(memberService);
            SignUpController signUpController = new SignUpController();
            new LoginView(loginController, signUpController); // 로그인 화면 띄우기

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
