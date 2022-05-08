package am.itspace.taskmanagement.manager;

import am.itspace.taskmanagement.db.DBConnectionProvider;
import am.itspace.taskmanagement.model.Task;
import am.itspace.taskmanagement.model.TaskStatus;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            preparedStatement.setInt(5, task.getUserId().getId());
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

    public List<Task> getAllTask() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM task");
        return getTasksFromTask(resultSet);
    }

    public List<Task> getAllTaskByUserId(int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM task where user_id=?");
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();
        return getTasksFromTask(resultSet);
    }

    private List<Task> getTasksFromTask(ResultSet resultSet) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getInt("id"));
            task.setName(resultSet.getString("name"));
            task.setDescription(resultSet.getString("description"));
            try {
                task.setDeadline(sdf.parse(resultSet.getString("deadline")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            task.setStatus(TaskStatus.valueOf(resultSet.getString("status")));
            task.setUserId(userManager.getUserById(resultSet.getInt("user_id")));
            tasks.add(task);
        }
        return tasks;
    }

    public void updateTask(int taskId, String newStatus) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE task set status = ? where id = ?");
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, taskId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
                        .userId(userManager.getUserById(resultSet.getInt(6)))
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
                        .userId(userManager.getUserById(resultSet.getInt(6)))
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
