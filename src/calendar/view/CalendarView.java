package calendar.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalendarView {
    private JFrame frame;
    private JButton logoutButton;

    public CalendarView() {
        createCalendarView();
    }

    public void createCalendarView() {
        frame = new JFrame("Calendar");
        JPanel panel = new JPanel(new BorderLayout());

        JLabel calendarLabel = new JLabel("Calendar View", SwingConstants.CENTER);
        logoutButton = new JButton("Logout");

        panel.add(calendarLabel, BorderLayout.CENTER);
        panel.add(logoutButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setLogoutButtonListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }
}