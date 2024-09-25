package calendar;

import calendar.controller.*;
import calendar.view.*;

public class CalendarApp {
    public static void main(String[] args) {
        try {
            ViewManager viewManager = new ViewManager();

            // 뷰 생성 및 등록
            LoginView loginView = new LoginView();
            SignUpView signUpView = new SignUpView();
            CalendarView calendarView = new CalendarView();

            viewManager.registerView(ViewEnum.LOGIN_VIEW, loginView.getFrame());
            viewManager.registerView(ViewEnum.SIGNUP_VIEW, signUpView.getFrame());
            viewManager.registerView(ViewEnum.CALENDAR_VIEW, calendarView.getFrame());

            // 컨트롤러 생성
            LoginController loginController = new LoginControllerImpl();
            SignUpController signUpController = new SignUpControllerImpl();
            CalendarController calendarController = new CalendarControllerImpl();

            // MainController 생성 (리스너도 여기서 설정)
            MainControllerImpl mainController = new MainControllerImpl(viewManager, loginController, signUpController, calendarController);

            // 뷰에 리스너를 MainController에서 설정
            mainController.setListeners(loginView, signUpView, calendarView);

            // 애플리케이션 시작
            mainController.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}