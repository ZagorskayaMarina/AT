import java.sql.Connection;

public class SetData {
    public static void main(String[] args) {
        String dropUsers = "DROP TABLE users;";
        String createUsers = "CREATE TABLE IF NOT EXIST 'users' (\n" +
                "'user_id' int(11) NOT NULL AUTO_INCREMENT,\n" +
                "'user_login' varchar(255),\n" +
                "'user_password' char(40),\n" +
                "PRIMARY KEY ('user_id')\n" +
                ");";
        String insertUser = "INSERT INTO 'users' ('user_login', 'user_password') values (?, ?);";
        String selectUser = "SELECT * FROM users";

        DBConnect dbConnect = new DBConnect();

    }
}
