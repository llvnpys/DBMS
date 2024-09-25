package calendar.controller;


import calendar.service.MemberService;

import javax.swing.*;

public class LoginController {
    private MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void handleLogin(String userId, String password) {
        if (memberService.authenticate(userId, password)) {
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
        }
    }


}