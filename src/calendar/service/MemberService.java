package calendar.service;

import calendar.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberService {

    private Connection connection;

    public MemberService(Connection connection) {
        this.connection = connection;
    }

    public boolean authenticate(String userId, String password) {
        String query = "SELECT password FROM my_calendar.user WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1).equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerMember(Member member) {
        String checkQuery = "SELECT COUNT(*) FROM my_calendar.user WHERE user_id = ?";
        try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
            checkStatement.setString(1, member.getId());
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                return false;
            }

            String insertQuery = "INSERT INTO my_calendar.user (user_id, password, user_name) VALUES (?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, member.getId());
                insertStatement.setString(2, member.getPassword());
                insertStatement.setString(3, member.getName());
                insertStatement.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
