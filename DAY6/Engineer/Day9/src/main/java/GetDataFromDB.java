import java.sql.SQLException;

public class GetDataFromDB {
    private static final int QUANTITY = 10;
    private static final int PASSWORD_LIGHT = 4;
    private static final int LOGIN_LIGHT = 6;
    public static void main(String[] args) throws SQLException {
        Operations operation = new Operations();
        //operation.dropTable();
        operation.createTable();
        //peration.insertUsers(QUANTITY,PASSWORD_LIGHT,LOGIN_LIGHT);
        //operation.selectUsers(Query.SELECT_USERS);
    }
}
