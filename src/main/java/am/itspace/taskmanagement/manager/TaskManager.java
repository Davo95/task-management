package am.itspace.taskmanagement.manager;

import am.itspace.taskmanagement.db.DBConnectionProvider;
import am.itspace.taskmanagement.model.Task;
import am.itspace.taskmanagement.model.TaskStatus;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private UserManager userManager = new UserManager();
    private final Connection connection = DBConnectionProvider.getProvider().getConnection();

    public void addTask(Task task) {
        try {
            String query = "INSERT INTO task (`name`,`description`,`deadline`,`status`,`user_id`) VALUES(?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, sdf.format(task.getDeadline()));
            preparedStatement.setString(4, task.getStatus().name());
            preparedStatement.setInt(5, task.getUser().getId());
            System.out.println(query);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                task.setId(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateTask(Task task) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE task SET name = '%s',description = '%s',status = '%s' WHERE id = " + task.getId(),
                    task.getName(), task.getDescription(), task.getStatus());
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Task> getTask() {
        String sql = "SELECT * from task";
        List<Task> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Task task = Task.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .deadline(resultSet.getDate(4))
                        .status(TaskStatus.valueOf(resultSet.getString(5)))
                        .user(userManager.getUserById(resultSet.getInt(6)))
                        .build();
                result.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Task getTaskById(int id) {
        String sql = "SELECT * from task WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Task.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .deadline(resultSet.getDate(4))
                        .status(TaskStatus.valueOf(resultSet.getString(5)))
                        .user(userManager.getUserById(resultSet.getInt(6)))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteTask(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM task WHERE id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
