package Client.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

import Client.JFrame.ClientFunction.ConnectMysql.ConnectMysql;
import Other.JavaSendMail;
import Other.StringRandom;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;



public class ClientUserAddFrame extends JFrame implements ActionListener {
    JLabel tiltLb = new JLabel("用户注册 ");
    JLabel nameLb = new JLabel("用 户 名");
    JLabel pwLb = new JLabel("密    码");
    JLabel againpwLb = new JLabel("再输密码");
    JLabel emailLb = new JLabel("邮    箱");
    JLabel checkin=new JLabel("验 证 码");
    JButton sendemailBtn=new JButton("发送邮件");
    JTextField nameTxt = new JTextField(15);
    JPasswordField pwTxt = new JPasswordField(15);
    JPasswordField againpwTxt = new JPasswordField(15);
    JPasswordField emailTxt = new JPasswordField(15);
    JTextField CheckNumberTxt=new JTextField(15);
    JButton determineBtn = new JButton("确定");
    JButton cancelBtn = new JButton("取消");
    JRadioButton maleBtn = new JRadioButton("男");
    JRadioButton FemaleBtn = new JRadioButton("女");
    ButtonGroup bg = new ButtonGroup();
    ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\bg2.jpg");
    JLayeredPane LayeredPane = new JLayeredPane();
    JLabel background = new JLabel(icon);
    ImageIcon icon1 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\3.png");
    ImageIcon icon2 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\13.png");
    StringRandom test=new StringRandom();
    String c=test.getStringRandom(8);

    public ClientUserAddFrame (){
        this.setTitle("WeChat");
        this.determineBtn.addActionListener(this);
        this.cancelBtn.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(410,450);
        this.setLayout(null);

        JPanel panel =(JPanel)this.getContentPane();
        this.getLayeredPane().setLayout(null);
        background.setBounds(0,0,400,500);
        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));

        determineBtn.setIcon(icon1);
        cancelBtn.setIcon(icon2);
        emailTxt.setBounds(140, 220, 150, 30);
        againpwTxt.setBounds(140, 170, 150, 30);
        againpwLb.setBounds(70, 170, 100, 30);
        tiltLb.setBounds(140, 20, 100, 30);
        nameLb.setBounds(70, 70, 100, 30);
        pwLb.setBounds(70, 120, 100, 30);
        nameTxt.setBounds(140, 70, 150, 30);
        pwTxt.setBounds(140, 120, 150, 30);
        emailLb.setBounds(70, 220, 100, 30);
        cancelBtn.setBounds(80, 380, 250, 25);
        determineBtn.setBounds(80, 340, 250, 25);
        maleBtn.setBounds(100, 300, 70, 30);
        FemaleBtn.setBounds(200, 300, 70, 30);
        checkin.setBounds(70,260,100,30);
        CheckNumberTxt.setBounds(140,260,150,30);
        sendemailBtn.setBounds(300,220,90,30);
        add(tiltLb);
        add(nameLb);
        add(nameTxt);
        add(pwLb);
        add(pwTxt);
        add(againpwLb);
        add(againpwTxt);
        add(emailLb);
        add(emailTxt);
        add(determineBtn);
        add(cancelBtn);
        add(maleBtn);
        add(FemaleBtn);
        add(sendemailBtn);
        add(checkin);
        add(CheckNumberTxt);
        tiltLb.setFont(new Font("宋体",Font.PLAIN,20));
        bg.add(maleBtn);
        bg.add(FemaleBtn);
        cancelBtn.setUI(new BEButtonUI(). setNormalColor(BEButtonUI.NormalColor.red));
        determineBtn.setUI(new BEButtonUI(). setNormalColor(BEButtonUI.NormalColor.green));
        determineBtn.setForeground(Color.WHITE);
        cancelBtn.setForeground(Color.WHITE);

        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\logo.jpg");
        this.setIconImage(icon1);
        panel.setOpaque(false);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientUserLoginFrame();
            }
        });

        determineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CheckNumberTxt.getText().length()==0&&CheckNumberTxt.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"输入验证码");
                }
//                else if(maleBtn.isSelected()){
//                    System.out.println("男");
//                }
//                else if(FemaleBtn.isSelected()){
//                    System.out.println("女");
//                }
                else {
                    String n=CheckNumberTxt.getText().toString();
                    System.out.println("文本验证码"+n);
                    System.out.println("验证码"+c);
                    if(n.equals(c)==true){
                        System.out.println("验证码正确！");
                        JOptionPane.showMessageDialog(null,"验证完成");
                        try {
                            String a=nameTxt.getText().toString();
                            String m=againpwTxt.getText().toString();
                            String o=emailTxt.getText().toString();
                            new ConnectMysql().AddNewUser(a,m,o);

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        sendemailBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameTxt.getText().length()==0||nameTxt.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"请填写用户名");
                }
                else if(pwTxt.getText().length()==0||pwTxt.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"请填写密码");
                }
                else if(againpwTxt.getText().length()==0||againpwTxt.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"请再次输入密码");

                }
                else if((pwTxt.getText().toString().equals(againpwTxt.getText().toString()))==false){
                    JOptionPane.showMessageDialog(null,"两次密码不一致");
                }
                else if(emailTxt.getText().length()==0||emailTxt.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"请填写邮箱号");
                }
//                else if(true != d){
//                    JOptionPane.showMessageDialog(null,"请输入正确的邮箱号，以完成注册");
//
//                }
                else {
                    String a=nameTxt.getText().toString();
                    String b=emailTxt.getText().toString();
                    try {
                       new ConnectMysql().ChekUser(a);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                    //String a=emailTxt.getText().toString();
                    String d="你好，我是小C。\n" +
                            "用户"+a+"，欢迎你注册HelloWorld,验证码是"+c+"，请注意保护自己的验证码。";
                    //JavaSendEmail.sendMail(b,d,"HelloWorld注册邮件");
                    JavaSendMail.sendMail(b,d,"HelloWorld注册邮件");
                    //sendEmailBtn.setBackground(Color.GRAY);
                    //int f=new TimeOut1().time1();
                    sendemailBtn.setEnabled(false);
                    sendemailBtn.setText("已经发送");
            }
            }
        });
    }
    public static boolean check1(String a){

        String RULE_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
                "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|" +
                "\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(a);
        //进行正则匹配\
        return m.matches();


    }



//    public static void main (String[] args){
//        try {
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        new ClientUserAddFrame();
//    }

    public void actionPerformed(ActionEvent e) {

//        new ClientUserLoginFrame();
//
//        this.dispose();
    }
}
