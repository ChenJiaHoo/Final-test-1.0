package Client.JFrame.server.UserMessage.ShowUserMessageFrame.UserMessageFunction;

import Client.JFrame.server.UserMessage.ShowUserMessageFrame.ShowUserMessageFrame;
import Other.JudgeTableIfExit;
import Other.Linksql;
import com.mysql.jdbc.util.ResultSetUtil;

import javax.swing.*;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectMyaql {
    public ConnectMyaql(){

    }
    //修改操作
    public String ChangeUserMessage(String a,String b,String c,String d)throws Exception{

        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
        Connection conn= DriverManager.getConnection(jdbc,"root","1234"); //连接数据库
        String sql="update user set UserPassWord=?,Email=?,NickName=? where UserName=?";
        PreparedStatement state=conn.prepareStatement(sql);
        state.setString(1,a);
        state.setString(2,b);
        state.setString(3,c);
        state.setString(4,d);
        boolean re=state.execute();
        if(re==false){
            System.out.println("修改成功");
            JOptionPane.showMessageDialog(null,d+"用户修改成功");
        }
        else {
            System.out.println(d+"修改失败");
        }
        return a;
    }
    //刷新操作
    public String getFlashUserMessage(String a)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
        Connection conn= DriverManager.getConnection(jdbc,"root","1234"); //连接数据库
        String sql="select *from user where UserName=?";
        PreparedStatement state=conn.prepareStatement(sql);
        state.setString(1,a);
        ResultSet re =state.executeQuery();
        //int index=0;

        while (re.next()){
            //System.out.println("message>>"+re.getString("UserName"));
            // System.out.println("password>>"+re.getString("UserPassword"));
            //System.out.println("Email>>"+re.getString("Email"));
            String e=re.getString("UserName");
            String f=re.getString("UserPassword");
            String g=re.getString("Email");
            String h=re.getString("NickName");
            new ShowUserMessageFrame(e,f,g,h);
        }
        re.close();
        state.close();
        conn.close();
//        if (re.next()) {
//            System.out.println("11111");
//        } else{
//            System.out.println("22222");
//
//        }
        return a;
    }


    public static void main(String[]args){
        String a ="chen8";
        String b="bbbb";
        String c="ccc";
        String d="123";
//        try {
//            new ConnectMyaql().getFlashUserMessage(a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            new ConnectMyaql().ChangeUserMessage(a,b,c,d);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }


}
