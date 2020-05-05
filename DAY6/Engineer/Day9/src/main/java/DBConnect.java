import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnect {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/megaapp" +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";
        return DriverManager.getConnection(url, "root", "11111Aa!");
    }

    public PreparedStatement preparedStatement(String query) throws SQLException {
        return connect().prepareStatement(query);
    }

    public ResultSet resultSet(String query) throws SQLException {
        Statement statement = connect().createStatement();
        return statement.executeQuery(query);
    }

}
