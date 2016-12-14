package demo;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hcq on 2016/10/27.
 */
public class ConnectDemo {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/xcq";
        String user = "xcq";
        String passwd = "qqq";

        try {
            Class.forName(driver);
            java.sql.Connection connection = DriverManager.getConnection(url,user,passwd);
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            System.out.println("初始化失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接失败");
            e.printStackTrace();
        }
    }
}
