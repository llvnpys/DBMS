package calendar.view;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ViewManager {
    private final Map<ViewEnum, JFrame> views = new HashMap<>();

    // 뷰 등록 메서드
    public void registerView(ViewEnum viewName, JFrame view) {
        views.put(viewName, view);
    }

    // 특정 뷰 표시
    public void show(ViewEnum viewName) {
        JFrame view = views.get(viewName);
        if (view != null) {
            view.setVisible(true);
        } else {
            System.out.println("View " + viewName + " not found.");
        }
    }

    // 특정 뷰 숨기기
    public void hide(ViewEnum viewName) {
        JFrame view = views.get(viewName);
        if (view != null) {
            view.setVisible(false);
        }
    }

    // 뷰 전환
    public void switchView(ViewEnum currentViewName, ViewEnum nextViewName) {
        hide(currentViewName);
        show(nextViewName);
    }
}