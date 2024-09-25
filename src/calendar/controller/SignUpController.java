package calendar.controller;

public interface SignUpController {
    // 회원가입 처리
    boolean signUp(String userId, String password, String name);
}