package Client.JFrame.ClientFunction.ConnectMysql;

import java.sql.*;


public class JDBC {
    private static Statement stat;
    public static Connection con;
    private static PreparedStatement pstat;
    private static void init() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_wechat?"+
                "user=root&password=1234";
        con = DriverManager.getConnection(url);
        con.createStatement().executeUpdate("use java_wechat");
    }
    public  static Statement getStat() throws ClassNotFoundException, SQLException{
        if(stat==null){
            init();
            stat = con.createStatement();}
        return stat;
    }
    public  static  PreparedStatement getPStat(String sql) throws ClassNotFoundException, SQLException{
        if(pstat==null){
            init();
        }
        pstat = con.prepareStatement(sql);
        return pstat;
    }




}


