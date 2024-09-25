package calendar.controller;

import calendar.view.SignUpView;

public class SignUpController {
    public void showSignUpView() {
        new SignUpView(this).createSignUpView();
    }
}
