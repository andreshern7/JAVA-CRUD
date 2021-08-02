package andres.learning.CRUD.authentication.controller.model.database;

import javax.sql.DataSource;
import java.sql.*;

public class DbConnection {

    private Connection connection;

    public DbConnection(DataSource connectionPool) {
        try {
            connection = connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getById(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        result.beforeFirst();
        if (!result.next()) {
            throw new SQLException("User with id: " + id + " not exist");
        }
        return result;
    }

    private int lastIdFromDb() {
        String query = "SELECT * FROM users;";
        int lastId=0;
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                lastId = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastId;
    }


    public ResultSet createUser(String name, String lastName, String userName,
                                String password, String country, String technology) {

        String query = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?);";
        ResultSet result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, userName);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, country);
            preparedStatement.setString(7, technology);
            preparedStatement.execute();
            result = getById(lastIdFromDb());System.out.println("createUser: "+result);
            System.out.println("createUser: USER INSERTED SUCCESSFULLY");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet getUserLogin(String username, String password){
        String query = "SELECT * FROM users WHERE (userName=? and password=?);";
        ResultSet result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            result = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
