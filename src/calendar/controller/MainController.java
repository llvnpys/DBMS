package calendar.controller;

public interface MainController {
    void start();

    // 로그인 처리
    void login(String userId, String password);

    // 회원가입 처리
    void signUp(String userId, String password, String name);

    // 로그아웃 처리
    void logout();
}