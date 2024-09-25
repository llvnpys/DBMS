package calendar.controller;

import calendar.view.*;

public class MainControllerImpl implements MainController {
    private final ViewManager viewManager;
    private final LoginController loginController;
    private final SignUpController signUpController;
    private final CalendarController calendarController;

    public MainControllerImpl(ViewManager viewManager, LoginController loginController, SignUpController signUpController, CalendarController calendarController) {
        this.viewManager = viewManager;
        this.loginController = loginController;
        this.signUpController = signUpController;
        this.calendarController = calendarController;
    }

    // 리스너 설정 메서드 (모든 뷰에 리스너를 설정)
    public void setListeners(LoginView loginView, SignUpView signUpView, CalendarView calendarView) {

        /*
        LoginView 리스너

        login :
        sign up :
        */

        loginView.setLoginButtonListener(e -> {
            String userId = loginView.getUserId();
            String password = loginView.getPassword();
            login(userId, password);
        });

        loginView.setSignUpButtonListener(e -> {
            viewManager.switchView(ViewEnum.LOGIN_VIEW, ViewEnum.SIGNUP_VIEW);
        });

        /*
        SignUpView 리스너

        sign up :
        cancel :
        */
        signUpView.setSignUpButtonListener(e -> {
            String userId = signUpView.getUserId();
            String password = signUpView.getPassword();
            String name = signUpView.getName();
            signUp(userId, password, name);
        });


        signUpView.setCancelButtonListener(e -> {
            viewManager.switchView(ViewEnum.SIGNUP_VIEW, ViewEnum.LOGIN_VIEW);
        });

        /*
        CalendarView 리스너

        sign up :
        cancel :
        */
    }



    @Override
    public void start() {
        // 애플리케이션 시작 시 로그인 뷰 표시
        viewManager.show(ViewEnum.LOGIN_VIEW);
    }

    @Override
    public void login(String userId, String password) {
        // 로그인 작업을 LoginController로 위임
        boolean success = loginController.login(userId, password);

        if (success) {
            // 로그인 성공 시 로그인 뷰에서 캘린더 뷰로 전환
            viewManager.switchView(ViewEnum.LOGIN_VIEW, ViewEnum.CALENDAR_VIEW);
        } else {
            System.out.println("Login failed.");
        }
    }

    @Override
    public void signUp(String userId, String password, String name) {
        // 회원가입 작업을 SignUpController로 위임
        boolean success = signUpController.signUp(userId, password, name);

        if (success) {
            // 회원가입 성공 시 로그인 화면으로 전환
            viewManager.switchView(ViewEnum.SIGNUP_VIEW, ViewEnum.LOGIN_VIEW);
        } else {
            System.out.println("Sign-up failed.");
        }
    }

    @Override
    public void logout() {
        // 로그아웃 시 캘린더 뷰에서 로그인 뷰로 전환
        viewManager.switchView(ViewEnum.CALENDAR_VIEW, ViewEnum.LOGIN_VIEW);
    }
}