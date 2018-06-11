package Other;

//为每一个新的登陆的用户创建一张属于自己的表
//表的名字是用户的名字

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Linksql {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //指定连接数据库的url
    final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
    //mysql用户名
    final static String name = "root";
    //mysql密码
    final static String pwd = "1234";
    public Linksql(String a){
        Connection conn = null;
        Statement stmt = null;
        try
        {
            String creatsql = "CREATE TABLE "+a+"("
                    + "UserNumber varchar(10),"
                    + "UserPictureWay varchar(100)"
                    + ")charset=utf8;";
            //注册jdbc驱动
            Class.forName(JDBC_DRIVER);
            //打开连接
            System.out.println("连接数据库java_wechat");
            conn = DriverManager.getConnection(DB_URL,name,pwd);
            //

            //执行创建表
            System.out.println("创建"+a+"表");
            stmt = conn.createStatement();
            if(0 == stmt.executeLargeUpdate(creatsql))
            {
                System.out.println("成功创建"+a+"表！");
                String b=null;
//                System.out.println(a);
//                System.out.println(b);
               // new Numbers().WriteNumber(a,b);
            }
            else
            {
                System.out.println("创建表"+a+"失败！");
            }
            //
            stmt.close();
            conn.close();
            System.out.println("//关闭资源");
        }
        catch(Exception e)
        {
            System.out.println("创建"+a+"表失败！");
            e.printStackTrace();
        }
    }


//   public static void main(String[] args)
//    {
//        String a="chen";
//        new Linksql(a);
//    }
}