package Client.JFrame.server;

import Client.JFrame.ClientFunction.ConnectMysql.ConnectMysql;

import javax.annotation.processing.SupportedOptions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//查找用户信息
public class LookForUser extends JFrame implements ActionListener {
    private JTextField LookForTxt;//查找用户信息的文本框
    private JButton SelectBtn;
    public LookForUser(){
        super("查询用户");
        this.setLayout(null);
        JPanel panel =(JPanel)this.getContentPane();
        this.setSize(300,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.LookForTxt=new JTextField(15);
        LookForTxt.setBounds(10,10,200,30);
        add(LookForTxt);
        this.SelectBtn=new JButton("查询用户信息");
        SelectBtn.setBounds(10,50,200,30);
        SelectBtn.setFont(new Font("宋体",Font.PLAIN,15));
        add(SelectBtn);
        panel.setOpaque(false);
        this.setVisible(true);
        this.setResizable(false);
        SelectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a=LookForTxt.getText().toString();
                try {
                    dispose();
                    new ConnectMysql().SearchFriends(a);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });













    }
    public static void main(String[]args){
        new LookForUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
