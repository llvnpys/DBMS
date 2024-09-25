package calendar.controller;

import calendar.view.LoginView;

public class LoginControllerImpl implements LoginController {


    @Override
    public boolean login(String userId, String password) {
        // 로그인 처리 로직
        System.out.println("Login attempt with User ID: " + userId);
        return true;  // 테스트를 위해 로그인 성공을 기본으로 설정
    }
}