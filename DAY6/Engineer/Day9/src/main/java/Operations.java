import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    DBConnect connect = new DBConnect();

    public void dropTable() throws SQLException {
        connect.preparedStatement(Query.DROP_TABLE).executeUpdate();
    }

    public void createTable() throws SQLException {
        connect.preparedStatement(Query.CREATE_TABLE).executeUpdate();
    }

    public void insertUsers(int quantity, int login, int password) throws SQLException {
        PreparedStatement statement = connect.preparedStatement(Query.INSERT_USERS);
        for (int i = 0; i < quantity; i++) {
            statement.setString(1, Generator.generateLogin(login));
            statement.setString(2, Generator.generatePassword(password));
            statement.executeUpdate();
        }
    }

    public void selectUsers(String query){
        List<User> users = new ArrayList<>();
        try{
            ResultSet resultSet = connect.resultSet(query);
            while (resultSet.next()){
                users.add(new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        users.forEach(user -> System.out.println(user.toString()));
    }

    /*public void showTables(String query){
        List<String> tables = new ArrayList<>();
    }*/
}
