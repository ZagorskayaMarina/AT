public class Query {
    public static String DROP_TABLE = "DROP TABLE users;";
    public static String CREATE_TABLE = "CREATE TABLE IF NOT EXIST 'users' (\n" +
            "'user_id' int(11) NOT NULL AUTO_INCREMENT,\n" +
            "'user_login' varchar(255),\n" +
            "'user_password' char(40),\n" +
            "PRIMARY KEY ('user_id')\n" +
            ");";
    public static String INSERT_USERS = "INSERT INTO 'users' ('user_login', 'user_password') values (?, ?);";
    public static String SELECT_USERS = "SELECT * FROM users";
    public static String SHOW_TABLES = "SHOW TABLES";

}
