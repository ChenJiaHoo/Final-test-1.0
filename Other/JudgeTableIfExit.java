package Other;
import java.sql.Connection;
import java.sql.*;
//查询表是否存在
public class JudgeTableIfExit {
    public JudgeTableIfExit(String a)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
        Connection conn= DriverManager.getConnection(jdbc,"root","1234"); //连接数据库
        ResultSet rs=conn.getMetaData().getTables(null,null,a,null);
        if(rs.next()){
            System.out.println("表"+a+"存在");
        }
        else {
            System.out.println("表"+a+"不存在");
            new Linksql(a);
        }
    }
//    public static void main(String[]args){
//        try {
//            String c="chen";
//            new JudgeTableIfExit(c);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
