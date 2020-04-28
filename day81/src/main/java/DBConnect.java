import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import com.sun.jdi.connect.spi.Connection;

public class DBConnect {
    public static void main(String[] args) {
        Properties prop = getProperties();
        prop.forEach((k,v) -> System.out.println(v.toString()));
        Connection connection = getDataSource(prop).getConnection();

    }

    private static Properties getProperties() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("day81/src/main/resources/db.properties")) {
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    private static MysqlDataSource getDataSource(Properties prop) {
        MysqlDataSource dataSource = new MysqlDataSource();

        return dataSource;
    }

    private static MysqlDataSource getDataSource(Properties prop) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(prop.getProperty("HOST"));
        dataSource.setPort(Integer.parseInt(prop.getProperty("PORT")));
        dataSource.setUser(prop.getProperty("USER"));
        dataSource.setPassword(prop.getProperty("PWD"));
        dataSource.setDatabaseName(prop.getProperty("DBNAME"));
        return dataSource;
    }
}