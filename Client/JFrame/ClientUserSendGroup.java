
package Client.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.mysql.jdbc.Statement;


public class ClientUserSendGroup extends JFrame implements ActionListener {
    public static Statement stat;
    JLabel Avatar = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\头像6.png"));
    JLabel Avatar1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\bg3.jpg"));
    JLabel nameLb = new JLabel();
    //JLabel psLb = new JLabel("personal signature");
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    //JSplitPane splitPane = new JSplitPane();

    JButton sendBtn = new JButton("发送");
    JButton cancelBtn = new JButton("取消");
    JButton AvatarBtn = new JButton("头像按钮");
    JTextArea textArea = new JTextArea();

    ImageIcon icon3 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\9.png");
    ImageIcon icon4 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\6.png");

    public ClientUserSendGroup (){
        this.setTitle("WeChat");
        this.cancelBtn.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);


        sendBtn.setIcon(icon3);
        cancelBtn.setIcon(icon4);
        panel.setBorder(BorderFactory.createTitledBorder("发送朋友圈"));
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.add(AvatarBtn, BorderLayout.WEST);
        AvatarBtn.setPreferredSize(new Dimension(70,70));
        panel.add(Avatar, BorderLayout.WEST);
        Avatar.setText("Avatar");
        Avatar.setPreferredSize(new Dimension(70,70));

        panel.add(panel1, BorderLayout.CENTER);
        panel1.setLayout(null);
        panel1.add(nameLb);
        nameLb.setBounds(10, 10, 50, 20);
        //panel1.add(psLb);
        //psLb.setBounds(10, 50, 500, 20);
        panel1.add(Avatar1);
        Avatar1.setBounds(0, 0, 700, 200);

        getContentPane().add(panel2, BorderLayout.CENTER);
        panel2.setLayout(null);
        panel2.add(textArea);
        textArea.setBounds(0, 0, 590, 200);

        getContentPane().add(panel3, BorderLayout.SOUTH);
        panel3.add(sendBtn);
        panel3.add(cancelBtn);


        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\logo.jpg");
        this.setIconImage(icon1);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());
        this.cancelBtn.addActionListener(this);
        this.sendBtn.addActionListener(this);

    }
    public static void main (String[] args){
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new ClientUserSendGroup();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(sendBtn)) {
            if (textArea.getText().equals(""))
                JOptionPane.showMessageDialog(null, "请输入内容！");
            else if (textArea.getText().length() != 0) {
                try{
                    // 获得连接
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/MySql?user=root&password=1234";
                    Connection con=DriverManager.getConnection(url);
                    stat=(Statement) con.createStatement();
                    url="use java_wechat";
                    System.out.println("连接成功");
                    stat.executeUpdate(url);

                    // 建立查询条件
                    StringBuilder sb = new StringBuilder();
                    sb.append("INSERT INTO circle_of_friends(uid,ucontent,time) VALUE(\'");
                    sb.append("1000\',\'");
                    sb.append(textArea.getText()+"\',");
                    sb.append("now());");

                    PreparedStatement pstm = con.prepareStatement(sb.toString());
                    System.out.println(sb);

                    JOptionPane.showMessageDialog(null, "发布成功！");
                    pstm.executeUpdate();
                    new ClientUserGroup();
                    this.dispose();

                }catch(ClassNotFoundException cnfe){
                    JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
                }catch(SQLException sqle){
                    JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        if(e.getSource()==cancelBtn){
            //new ClientUserMainFrame();
            this.dispose();
        }

    }
    private String getDate() {
        // TODO Auto-generated method stub
        return String.valueOf(System.currentTimeMillis());
    }

}


