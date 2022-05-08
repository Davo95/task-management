package am.itspace.taskmanagement.manager;

import am.itspace.taskmanagement.db.DBConnectionProvider;
import am.itspace.taskmanagement.model.User;
import am.itspace.taskmanagement.model.UserType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private final Connection connection = DBConnectionProvider.getProvider().getConnection();

    public void addUser(User user) {
        try {
            String query = "INSERT INTO user (`name`,`surname`,`user_type`,`email`,`password`) VALUES(?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUserType().name());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            System.out.println(query);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                user.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUser() throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setUserType(UserType.valueOf(resultSet.getString("user_type")));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
            return users;

    }

    public void updateUser(User user) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE user SET name = '%s',surname = '%s',email = '%s',password = '%s' WHERE id = " + user.getId(),
                    user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getUser() {
        String sql = "SELECT * from user";
        List<User> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .userType(UserType.valueOf(resultSet.getString(4)))
                        .email(resultSet.getString(5))
                        .password(resultSet.getString(6))
                        .build();
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User getUserById(int id) {
        String sql = "SELECT * from user WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .userType(UserType.valueOf(resultSet.getString(4)))
                        .email(resultSet.getString(5))
                        .password(resultSet.getString(6))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * from user WHERE email = '" + email + "' and password = '" + password + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .userType(UserType.valueOf(resultSet.getString(4)))
                        .email(resultSet.getString(5))
                        .password(resultSet.getString(6))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUser(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
