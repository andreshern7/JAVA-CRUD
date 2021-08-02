package andres.learning.CRUD.authentication.controller.model.database;

import andres.learning.CRUD.authentication.controller.model.ResponseUser;
import andres.learning.CRUD.authentication.controller.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProcessing {

    DbConnection dbConnection;

    public DataProcessing(DataSource connectionPool) {
        dbConnection = new DbConnection(connectionPool);
    }

    public ResponseUser createUser(String name, String lastName,
                                   String userName, String password, String country, String technology) {
        //User newUser = new User(name, lastName, userName, password, country, technology);
        ResultSet newUser = dbConnection.createUser(name, lastName, userName, password, country, technology);
        ResponseUser foundUserResponse = null;
        try {
            newUser.beforeFirst();
            foundUserResponse = createResponseUserObject(newUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundUserResponse;
    }

    public ResponseUser getUserLogin(String username, String password) throws SQLException {
        ResultSet userDbData = dbConnection.getUserLogin(username, password);
        ResponseUser foundUserResponse = null;
        if (userDbData.next()) {
            System.out.println(userDbData.getString("userName"));
            System.out.println(userDbData.getString("password"));
            foundUserResponse = createResponseUserObject(userDbData);
            System.out.println(foundUserResponse);
        } else {
            throw new SQLException("Invalid User Data");
        }
        return foundUserResponse;
    }

    private ResponseUser createResponseUserObject(ResultSet resultSet) {
        ResponseUser foundUserResponse = null;
        try {
            resultSet.beforeFirst();
            if (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String userName = resultSet.getString(4);
                String password = resultSet.getString(5);
                String country = resultSet.getString(6);
                String technology = resultSet.getString(7);
                User foundUserById = new User(userId, name, lastName, userName, password, country, technology);
                foundUserResponse = new ResponseUser(foundUserById);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundUserResponse;
    }
}
