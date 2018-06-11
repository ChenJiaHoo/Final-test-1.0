package Client.JFrame;


import Client.JFrame.ClientFunction.ConnectMysql.JDBC;
import Other.Linksql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

public class ClientUserInforamationFrame extends JFrame implements ActionListener {
    //组件
    JLabel Avatar = new JLabel(new ImageIcon(""));
    JLabel label1 = new JLabel(" 用户名:");
    JLabel label2 = new JLabel(" 密码:");
    JLabel label3 = new JLabel(" 邮箱:");
    JLabel label4=new JLabel("请输入ID：");


    JLabel nameLb = new JLabel("   头像");

    JTextField Txt = new JTextField(15);
    JTextField Txt1 = new JTextField(15);
    JTextField Txt2 = new JTextField(15);
    JTextField Txt3=new JTextField(15);


    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JButton loginBtn = new JButton("确定修改");
    JButton cancelBtn = new JButton("关闭");
    JButton AvatarBtn = new JButton("头像");
    JButton bt1=new JButton("确认");


    public ClientUserInforamationFrame(){
        //窗口属性
        this.setTitle("个人信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,500);
        this.setLocationRelativeTo(null);

        //设置组件
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createTitledBorder("个人信息"));
        panel.add(AvatarBtn, BorderLayout.EAST);
        AvatarBtn.setPreferredSize(new Dimension(70,70));

        Avatar.setPreferredSize(new Dimension(70,70));
        panel1.setLayout(new BorderLayout());
        panel.add(panel1, BorderLayout.CENTER);
        panel1.add(nameLb, BorderLayout.CENTER);


        panel2.setLayout(new BorderLayout());
        FlowLayout flowLayout = new FlowLayout();
        getContentPane().add(panel2, BorderLayout.SOUTH);
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel3.setLayout(flowLayout);
        panel2.add(panel3);
        panel3.add(loginBtn);
        loginBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        loginBtn.setHorizontalAlignment(SwingConstants.LEFT);

        panel2.add(panel4, BorderLayout.EAST);
        panel4.add(cancelBtn);

        getContentPane().add(panel5, BorderLayout.CENTER);
        panel5.setLayout(null);
        panel5.add(label1);
        label1.setBounds(40, 70, 80, 20);
        panel5.add(label2);
        label2.setBounds(60, 150, 50, 20);
        panel5.add(label3);
        label3.setBounds(70, 230, 50, 20);
        panel5.add(label4);
        label4.setBounds(30,30,80,20);

        panel5.add(bt1);
        bt1.setBounds(220,30,60,20);

        panel5.add(Txt);
        Txt.setBounds(110, 70, 110, 20);
        panel5.add(Txt1);
        Txt1.setBounds(110, 150, 110, 20);
        panel5.add(Txt2);
        Txt2.setBounds(110, 230, 110, 20);
        panel5.add(Txt3);
        Txt3.setBounds(110,30,110,20);


        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(getOwner());


        AvatarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });//头像按钮


        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });//关闭按钮


        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/java_wechat?" + "user=root&password=1234";
                    Connection con=DriverManager.getConnection(url);
                    Statement stmt=con.createStatement();
                    String sql="select UserPassWord,Email,NickName from user where  UserName='"+Txt3.getText()+"'";
                    ResultSet rs=stmt.executeQuery(sql);
                    while (rs.next()){
                        Txt.setText(rs.getString("NickName"));
                        Txt1.setText(rs.getString("UserPassWord"));
                        Txt2.setText(rs.getString("Email"));
                    }
                    rs.close();
                    stmt.close();
                    con.close();

                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });//确认按钮,显示输入ID的个人信息

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/java_wechat?" + "user=root&password=1234";
                    Connection con=DriverManager.getConnection(url);
                    Statement stmt=con.createStatement();
                    String sql="update user set NickName='"+Txt.getText()+"',UserPassWord='"+Txt1.getText()+"',Email='"+Txt2.getText()+"' where UserName='"+Txt3.getText()+"'";
                    PreparedStatement pstat=JDBC.getPStat(sql);
                    pstat.executeUpdate(sql);

                    JOptionPane.showMessageDialog(null,"保存成功");
                    dispose();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });//修改按钮
    }


    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ClientUserInforamationFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
