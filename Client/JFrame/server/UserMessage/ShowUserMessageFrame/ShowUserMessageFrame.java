package Client.JFrame.server.UserMessage.ShowUserMessageFrame;

import Client.JFrame.ClientUserMainFrame;
import Client.JFrame.server.UserMessage.ShowUserMessageFrame.UserMessageFunction.ConnectMyaql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowUserMessageFrame extends JFrame implements ActionListener {
    private JLabel UserNameLb;//用户名
    private JLabel UserPassWordLb;//用户密码
    private JLabel EmailLb;//用户的邮箱
    private JLabel NickNameLb;//用户的昵称

    private JLabel ShowUserName;//显示
    private JLabel ShowUserPassWord;
    private JLabel ShowEmail;
    private JLabel ShowNickName;

    private JButton ChangeBtn;//修改操作按钮
    private JButton FlashBtn;//刷新按钮，重写方法
    private JButton CanelBtn;
    public ShowUserMessageFrame(String a,String b,String c,String d){
        super("用户信息");
        //String a="aaaaaa";//测试
        this.setSize(400,500);
        this.setLayout(null);
        this.setLocation(100,100);
        this.setVisible(true);
        this.setResizable(false);
        //用户名板块
        this.UserNameLb=new JLabel("用户名：");
        UserNameLb.setBounds(10,10,100,30);
        UserNameLb.setFont(new Font("宋体",Font.PLAIN,20));
        add(UserNameLb);
        this.ShowUserName=new JLabel(a);
        ShowUserName.setBounds(110,10,100,30);
        ShowUserName.setFont(new Font("宋体",Font.PLAIN,20));
        add(ShowUserName);
        //用户密码板块
        this.UserPassWordLb=new JLabel("密  码：");
        UserPassWordLb.setBounds(10,60,100,30);
        UserPassWordLb.setFont(new Font("宋体",Font.PLAIN,20));
        add(UserPassWordLb);
        this.ShowUserPassWord=new JLabel(b);
        ShowUserPassWord.setBounds(110,60,100,30);
        ShowUserPassWord.setFont(new Font("宋体",Font.PLAIN,20));
        add(ShowUserPassWord);
        //邮箱模块
        this.EmailLb=new JLabel("你的邮箱：");
        EmailLb.setBounds(10,110,100,30);
        EmailLb.setFont(new Font("宋体",Font.PLAIN,20));
        add(EmailLb);
        this.ShowEmail=new JLabel(c);
        ShowEmail.setBounds(110,110,200,30);
        ShowEmail.setFont(new Font("宋体",Font.PLAIN,20));
        add(ShowEmail);
        //昵称模块
        this.NickNameLb=new JLabel("昵  称：");
        NickNameLb.setBounds(10,160,100,30);
        NickNameLb.setFont(new Font("宋体",Font.PLAIN,20));
        add(NickNameLb);
        this.ShowNickName=new JLabel(d);
        ShowNickName.setBounds(110,160,100,30);
        ShowNickName.setFont(new Font("宋体",Font.PLAIN,20));
        add(ShowNickName);
        //按钮模块
        this.ChangeBtn=new JButton("修改个人信息");
        ChangeBtn.setBounds(100,200,200,30);
        ChangeBtn.setFont(new Font("宋体",Font.PLAIN,20));
        add(ChangeBtn);
        this.FlashBtn=new JButton("刷新当前页面");
        FlashBtn.setBounds(100,300,200,30);
        FlashBtn.setFont(new Font("宋体",Font.PLAIN,20));
        add(FlashBtn);
        //返回按钮
        this.CanelBtn=new JButton("返回上一层");
        CanelBtn.setBounds(100,400,200,30);
        CanelBtn.setFont(new Font("宋体",Font.PLAIN,20));
        add(CanelBtn);
        String e=a;//传递用户名
        //修改按钮事件操作
        ChangeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String r;//传递用户名
                r = a;
                String z;
                z=b;
                new ChangeUserMessageFrame(r,z);

            }
        });
        //刷新
        FlashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String h=a;
                dispose();
                try {
                    new ConnectMyaql().getFlashUserMessage(h);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        CanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String r;//传递用户名
                r = a;
                String z;
                z=b;
                new ClientUserMainFrame(r,z);
            }
        });








    }





















//    public static void main(String[]args){
//        String a="chen8";
//        String b=null;
//        String c=null;
//        String d=null;
//       new ShowUserMessageFrame(a,b,c,d);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
