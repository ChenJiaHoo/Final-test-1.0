package Client.JFrame.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;




public class ClientUserLoginFrame extends JFrame implements ActionListener {
    public static Statement stat;
    JLabel tiltLb = new JLabel("WeChat");
    JLabel nameLb = new JLabel("用户名");
    JLabel pwLb = new JLabel("密  码");
    public static JTextField nameTxt = new JTextField(15);
    JPasswordField pwTxt = new JPasswordField(15);
    JRadioButton userBtn = new JRadioButton("个人用户");
    JRadioButton BusinesusersBtn = new JRadioButton("企业用户");

    JButton loginBtn = new JButton("登录");
    JButton cancelBtn = new JButton("取消");
    JButton addBtn = new JButton("注册");
    ButtonGroup bg = new ButtonGroup();
    ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\2.png");
    ImageIcon icon1 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\bg2.jpg");
    ImageIcon icon2 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\3.png");
    ImageIcon icon3 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\13.png");
    JLayeredPane LayeredPane = new JLayeredPane();
    JLabel background = new JLabel(icon1);
    JPanel panel = new JPanel();

    public ClientUserLoginFrame (){
        this.setTitle("WeChat");
        this.loginBtn.addActionListener(this);
        this.addBtn.addActionListener(this);
        this.userBtn.addActionListener(this);
        this.BusinesusersBtn.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,460);
        JPanel panel =(JPanel)this.getContentPane();

        this.getLayeredPane().setLayout(null);
        background.setBounds(0,0,400,400);
        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));


        //Container c = this.getContentPane();
        loginBtn.setIcon(icon);
        cancelBtn.setIcon(icon3);
        addBtn.setIcon(icon2);
        panel.setLayout(null);
        panel.add(tiltLb);
        panel.add(nameLb);
        panel.add(nameTxt);
        panel.add(pwLb);
        panel.add(pwTxt);
        panel.add(userBtn);
        panel.add(BusinesusersBtn);

        panel.add(addBtn);
        panel.add(loginBtn);
        panel.add(cancelBtn);
        userBtn.setBounds(80, 220, 140, 20);
        BusinesusersBtn.setBounds(220, 220, 140, 20);

        tiltLb.setBounds(150, 20, 100, 30);
        nameLb.setBounds(70, 70, 100, 30);
        pwLb.setBounds(70, 120, 100, 30);
        nameTxt.setBounds(150, 70, 150, 30);
        pwTxt.setBounds(150, 120, 150, 30);
        loginBtn.setBounds(80, 260, 250, 30);
        cancelBtn.setBounds(80, 340, 250, 30);
        addBtn.setBounds(80, 300, 250, 30);
        tiltLb.setFont(new Font("宋体",Font.PLAIN,20));

        bg.add(userBtn);
        bg.add(BusinesusersBtn);

        //loginBtn.setUI(new BEButtonUI(). setNormalColor(BEButtonUI.NormalColor.green));
        cancelBtn.setUI(new BEButtonUI(). setNormalColor(BEButtonUI.NormalColor.red));
        addBtn.setUI(new BEButtonUI(). setNormalColor(BEButtonUI.NormalColor.lightBlue));
        //loginBtn.setForeground(Color.WHITE);
        cancelBtn.setForeground(Color.WHITE);
        addBtn.setForeground(Color.WHITE);





        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\logo.jpg");
        this.setIconImage(icon1);
        panel.setOpaque(false);
        this.setVisible(true);
        this.setResizable(true);
        this.setLocationRelativeTo(getOwner());



    }
    public static void main (String[] args){
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new ClientUserLoginFrame();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginBtn )
        {
            if(userBtn.isSelected() )
            {
               // new ClientUserMainFrame();
                this.dispose();
            }
        }
        if(e.getSource()== loginBtn )
        {
            //企业登录
            if(BusinesusersBtn.isSelected() )
            {
                if (nameTxt.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "请输入账号！");
                else if (pwTxt.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "请输入密码！");
                else if (nameTxt.getText().length() != 0
                        && pwTxt.getText().length() != 0) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url="jdbc:mysql://localhost:3306/MySql?user=root&password=1234";
                        Connection con=DriverManager.getConnection(url);
                        stat=con.createStatement();
                        url="use java_wechat";
                        System.out.println("连接成功");
                        stat.executeUpdate(url);

                        // 建立查询条件
                        String sql = "select cid,cpwd from company";
                        PreparedStatement pstm = con.prepareStatement(sql);
                        ResultSet rs = pstm.executeQuery();
                        String getid=nameTxt.getText();
                        String getpw=pwTxt.getText();
                        while(rs.next()){
                            String ID=rs.getString(1);
                            String pw=rs.getString(2);
                            if(ID.equals(getid)&&pw.equals(getpw))
                                new ClientCompanyMainFrame();
                            this.dispose();
                        }}
                    catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                           if(e.getSource()==addBtn){
                  //  new ClientUserAddFrame();
                    this.dispose();
                }
            }
        }
    }
}



