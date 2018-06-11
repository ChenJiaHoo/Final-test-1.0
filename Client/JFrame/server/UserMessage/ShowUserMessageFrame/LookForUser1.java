package Client.JFrame.server.UserMessage.ShowUserMessageFrame;

import Client.JFrame.ClientFunction.ConnectMysql.ConnectMysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookForUser1 extends JFrame implements ActionListener {
    private JTextField LookForTxt;//查找用户信息的文本框
    private JButton SelectBtn;
    private JLabel UserNameLb;
    private JLabel EmailLb;
    private JLabel NickNameLb;
    private JLabel UserNameLb1;
    private JLabel EmailLb1;
    private JLabel NickNameLb1;
    private JButton CanelBtn;

    public LookForUser1(String a,String b,String c) {
        super(a+"用户");
        this.setLayout(null);
        JPanel panel = (JPanel) this.getContentPane();
        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.LookForTxt = new JTextField(15);
        LookForTxt.setBounds(10, 10, 200, 30);
        add(LookForTxt);
        this.SelectBtn = new JButton("查询用户信息");
        SelectBtn.setBounds(10, 50, 200, 30);
        SelectBtn.setFont(new Font("宋体", Font.PLAIN, 15));
        add(SelectBtn);
        this.UserNameLb1=new JLabel(a);
        UserNameLb1.setBounds(120,90,200,30);
        UserNameLb1.setFont(new Font("宋体", Font.PLAIN, 15));
        add(UserNameLb1);
        this.UserNameLb=new JLabel("用户名：");
        UserNameLb.setBounds(10,90,100,30);
        UserNameLb.setFont(new Font("宋体", Font.PLAIN, 15));
        add(UserNameLb);

        this.EmailLb=new JLabel("邮箱号：");
        EmailLb.setBounds(10,150,100,30);
        EmailLb.setFont(new Font("宋体", Font.PLAIN, 15));
        add(EmailLb);
        this.EmailLb1=new JLabel(b);
        EmailLb1.setBounds(120,150,200,30);
        EmailLb1.setFont(new Font("宋体", Font.PLAIN, 15));
        add(EmailLb1);

        this.NickNameLb=new JLabel("昵  称：");
        NickNameLb.setBounds(10,200,100,30);
        NickNameLb.setFont(new Font("宋体", Font.PLAIN, 15));
        add(NickNameLb);
        this.NickNameLb1=new JLabel(c);
        NickNameLb1.setBounds(120,200,200,30);
        NickNameLb1.setFont(new Font("宋体", Font.PLAIN, 15));
        add(NickNameLb1);
        this.CanelBtn=new JButton("退出");
        CanelBtn.setBounds(10,400,100,30);
        CanelBtn.setFont(new Font("宋体", Font.PLAIN, 15));
        add(CanelBtn);

        panel.setOpaque(false);
        this.setVisible(true);
        this.setResizable(false);
        SelectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = LookForTxt.getText().toString();
                try {
                    new ConnectMysql().SearchFriends(a);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        CanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

    public static void main(String[]args){
        //new LookForUser1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
