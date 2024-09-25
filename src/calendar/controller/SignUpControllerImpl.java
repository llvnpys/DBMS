package calendar.controller;

import calendar.controller.SignUpController;


public class SignUpControllerImpl implements SignUpController {


    @Override
    public boolean signUp(String userId, String password, String name) {
        // 회원가입 처리 로직
        System.out.println("Sign-up attempt with User ID: " + userId + ", Name: " + name);

        return true;
    }
}