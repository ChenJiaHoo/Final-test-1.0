package Client.JFrame.ClientFunction.ConnectMysql;


import java.sql.*;

public class JDBC1 {
    public static Connection con;
    public static PreparedStatement sql;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:" + "//127.0.01:3306/java_wechat?characterEncoding=GBK&useSSL=false",
                    "root", "1234");
            System.out.println("数据库连接成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}