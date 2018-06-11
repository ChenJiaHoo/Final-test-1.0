package Client.JFrame.ClientFunction.ConnectMysql;


//import Client.JFrame.ClientLookForUser;
import Client.JFrame.ClientUserAddFrame;
import Client.JFrame.ClientUserLoginFrame;
import Client.JFrame.ClientUserMainFrame;
import Client.JFrame.server.UserMessage.ShowUserMessageFrame.LookForUser1;
import Other.JudgeTableIfExit;
import Other.Linksql;

import javax.swing.*;
import java.sql.*;

public class ConnectMysql extends JFrame {
    public ConnectMysql(){
    }
    //登陆验证
    public void EnterCheck(String a,String b)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
        Connection conn= DriverManager.getConnection(jdbc,"root","1234"); //连接数据库
        String sql="select *from user where UserName=? and UserPassWord=?";
        PreparedStatement state=conn.prepareStatement(sql);
        state.setString(1,a);
        state.setString(2,b);
        ResultSet re =state.executeQuery();
        if (re.next()) {
            System.out.println("用户 "+a+"登入成功！");//后台显示
            JOptionPane.showMessageDialog(null,"登入完成");
//            System.out.println(a);
//            System.out.println(b);
            //new Main(a);
            dispose();
            new JudgeTableIfExit(a);
            new ClientUserMainFrame(a,b);

        } else{
            System.out.println("用户名或者密码错误！");//后台显示
            JOptionPane.showMessageDialog(null,"用户名"+a+"或者密码错误！");
        }
    }
    //注册
    public void AddNewUser(String e,String f,String j)throws Exception{
        //String g=(String)("A"+(int)(Math.random()*900+100));
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
        Connection conn= DriverManager.getConnection(jdbc,"root","1234");//连接数据库
        String sql = "insert into user values(?,?,?,0,0)";
        PreparedStatement state = conn.prepareStatement(sql);
        // state.setString(1,g);
        state.setString(1,e);
        state.setString(2,f);
        state.setString(3,j);
        int i = state.executeUpdate();
        if (i == 1) {
            JOptionPane.showMessageDialog(null, "注册成功");
            System.out.println("用户 "+e+"注册成功");
            this.dispose();//释放AddUser界面回到Longin界面
            new ClientUserLoginFrame();
        } else {
            JOptionPane.showMessageDialog(null, "失败");
            System.out.println("注册失败");
        }
    }
    //查询用户名称是否存在
    public void ChekUser(String e)throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
        Connection conn= DriverManager.getConnection(jdbc,"root","1234");//连接数据库
        String sql="select *from user where UserName=?";
        PreparedStatement state = conn.prepareStatement(sql);
        state.setString(1,e);
        ResultSet re =state.executeQuery();
        if (re.next()) {
            System.out.println(e+"：用户名字已经存在");//后台显示
            JOptionPane.showMessageDialog(null,"用户名已经存在");
            dispose();
            new ClientUserAddFrame();

        } else{
            System.out.println(e+"：用户名可用");//后台显示
        }
        dispose();

    }












    //添加好友
    public  void SearchFriends(String a) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/java_wechat?characterEncoding=GBK&useSSL=false";
        Connection conn= DriverManager.getConnection(jdbc,"root","1234");//连接数据库
        String sql="select *from user where UserName=?";
        PreparedStatement state = conn.prepareStatement(sql);
        state.setString(1,a);
        ResultSet re =state.executeQuery();
        while (re.next()){
            String d=re.getString("UserName");
            String b=re.getString("Email");
            String c=re.getString("NickName");
            new LookForUser1(d,b,c);
        }
        re.close();
        state.close();
        conn.close();
    }

    public static void Addconfirm() throws SQLException {
        //int rowindex = ClientLookForUser.table.getSelectedRow();
        //String getfid = (String) ClientLookForUser.table.getValueAt(rowindex, 0);

//        String getuid=ClientUserLoginFrame.nameTxt.getText();
//        int id=Integer.parseInt(getuid);
//
//        PreparedStatement sql =JDBC1.con.prepareStatement("INSERT into friend VALUES(?,?) ");
//        sql.setString(1, "162011444");
//        sql.setString(2, getfid);
//        sql.executeUpdate();
//        JOptionPane.showMessageDialog(null, "好友添加成功");
    }












    public void Backut(){

    }



}