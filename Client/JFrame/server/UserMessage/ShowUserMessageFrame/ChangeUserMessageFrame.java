package Client.JFrame.server.UserMessage.ShowUserMessageFrame;

import Client.JFrame.server.UserMessage.ShowUserMessageFrame.UserMessageFunction.ConnectMyaql;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeUserMessageFrame extends JFrame implements ActionListener {
    JLabel UserNameLb = new JLabel("用户名： ");
    JLabel UserPassWordLb = new JLabel("密  码：");
    JLabel EmailLb = new JLabel("邮  箱：");
    JLabel NickNameLb = new JLabel("昵  称：");
    JTextField UserPassWordTxt = new JTextField(15);
    JTextField EmailTxt = new JTextField(15);
    JTextField NickNameTxt=new JTextField(15);
    JButton OKBtn=new JButton("确认修改");
    JButton AgainBtn=new JButton("重置内容");
    JButton CanelBtn=new JButton("返回主页面");
    JLayeredPane LayeredPane = new JLayeredPane();
    public ChangeUserMessageFrame(String e,String f){
        super("修改个人信息");
        String d;//获取用户名
        d=e;
        String j;//用户密码
        j=f;
        JLabel UserNameLb1=new JLabel(d);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(410,450);
        this.setLayout(null);
        JPanel panel =(JPanel)this.getContentPane();
        this.getLayeredPane().setLayout(null);
        UserNameLb.setBounds(10,10,100,30);
        UserNameLb.setFont(new Font("宋体",Font.PLAIN,20));
        UserPassWordLb.setBounds(10,50,100,30);
        UserPassWordLb.setFont(new Font("宋体",Font.PLAIN,20));
        EmailLb.setBounds(10,90,100,30);
        EmailLb.setFont(new Font("宋体",Font.PLAIN,20));
        NickNameLb.setBounds(10,130,100,30);
        NickNameLb.setFont(new Font("宋体",Font.PLAIN,20));
        UserNameLb1.setBounds(120,10,200,30);
        UserPassWordTxt.setBounds(120,50,200,30);
        UserPassWordTxt.setText(f);
        EmailTxt.setBounds(120,90,200,30);
        NickNameTxt.setBounds(120,130,200,30);
        OKBtn.setBounds(20,200,200,30);
        AgainBtn.setBounds(20,250,200,30);
        CanelBtn.setBounds(20,300,200,30);
        add(UserNameLb);
        add(UserPassWordLb);
        add(EmailLb);
        add(NickNameLb);
        add(UserNameLb1);
        add(UserPassWordTxt);
        add(EmailTxt);
        add(NickNameTxt);
        add(OKBtn);
        add(AgainBtn);
        add(CanelBtn);
        panel.setOpaque(false);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());
//        String d;//获取用户名
//        d=e;
        OKBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (UserPassWordTxt.getText().equals("")||UserPassWordTxt.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"请填写密码！");
                }
                if (EmailTxt.getText().length()==0||EmailTxt.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请填写邮箱！");
                }
                if(NickNameTxt.getText().equals("")||NickNameTxt.getText().length()==0){
                    JOptionPane.showMessageDialog(null,"请填写昵称");
                }
                else{
                String a=UserPassWordTxt.getText().toString();
                String b=EmailTxt.getText().toString();
                String c=NickNameTxt.getText().toString();
                try {
                    new ConnectMyaql().ChangeUserMessage(a,b,c,d);
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                }

            }
        });
        AgainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserPassWordTxt.setText("");
                EmailTxt.setText("");
                NickNameTxt.setText("");
            }
        });
        CanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

//    public static void main(String[]args){
//        try {
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        new ChangeUserMessageFrame();
//    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
