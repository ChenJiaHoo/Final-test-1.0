package Client.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.mysql.jdbc.Statement;

public class ClientUserGroup extends JFrame implements ActionListener {
    public static Statement stat;
    JLabel Avatar = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\头像6.png"));
    JLabel Avatar1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\1.jpg"));
    JLabel Avatar2 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\timg2.jpeg"));
    JLabel bg = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\bg3.jpg"));
    //JLabel label1 = new JLabel(new ImageIcon("images/timg1.jpg"));
    //JLabel label2 = new JLabel(new ImageIcon("images/timg1.jpg"));
    //JLabel label3 = new JLabel(new ImageIcon("images/timg1.jpg"));
    JLabel label4 = new JLabel(new ImageIcon(""));
    JLabel label5 = new JLabel(new ImageIcon(""));
    JLabel label6 = new JLabel(new ImageIcon(""));
    //JLabel label7 = new JLabel("Do one thing at a time, and do well.");
    //JLabel label8 = new JLabel("Never forget to say “thanks”.");
    JLabel nameLb = new JLabel();
    //JLabel psLb = new JLabel("personal signature");
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JTextArea textArea = new JTextArea();
    JTextArea textArea1 = new JTextArea();
    JTextField commentTxt = new JTextField();
    JTextField commentTxt1 = new JTextField();
    JButton UpdatedBtn = new JButton("发朋友圈");
    //JButton UpdatedBtn = new JButton("");
    JButton returnBtn = new JButton("返回");
    //点赞
    JButton likeBtn = new JButton();
    JButton likeBtn1 = new JButton();
    JTextField Jdianzan = new JTextField();
    JTextField Jdianzan1 = new JTextField();
    JButton commentBtn = new JButton("评论");
    JButton commentBtn1 = new JButton("评论");
    JButton AvatarBtn = new JButton("头像按钮");
    JButton AvatarBtn1 = new JButton("头像按钮1");
    JButton AvatarBtn2 = new JButton("头像按钮2");
    ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\13.png");
    ImageIcon icon1 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\15.png");
    ImageIcon icon2 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\18.png");
    ImageIcon icon3 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\19.png");

    public ClientUserGroup() {
        this.setTitle("WeChat");
        this.likeBtn1.addActionListener(this);
        this.commentBtn1.addActionListener(this);
        this.returnBtn.addActionListener(this);
        this.UpdatedBtn.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(560, 600);

        UpdatedBtn.setIcon(icon2);
        returnBtn.setIcon(icon);
        likeBtn.setIcon(icon3);
        likeBtn1.setIcon(icon3);
        commentBtn.setIcon(icon1);
        commentBtn1.setIcon(icon1);
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setBorder(BorderFactory.createTitledBorder("朋友圈"));
        panel.add(AvatarBtn, BorderLayout.EAST);
        AvatarBtn.setPreferredSize(new Dimension(70, 70));
        Avatar.setText("Avatar");
        panel.add(Avatar, BorderLayout.EAST);
        Avatar.setPreferredSize(new Dimension(70, 70));

        panel1.setLayout(new BorderLayout());
        panel.add(panel1, BorderLayout.CENTER);
        panel1.add(nameLb, BorderLayout.CENTER);
        //panel1.add(psLb, BorderLayout.SOUTH);


        panel2.setLayout(new BorderLayout());
        getContentPane().add(panel2, BorderLayout.SOUTH);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel3.setLayout(flowLayout);
        panel2.add(panel3);
        panel3.setBackground(Color.WHITE);
        panel3.add(returnBtn);
        returnBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        returnBtn.setHorizontalAlignment(SwingConstants.LEFT);
        panel3.add(UpdatedBtn);
        panel2.add(panel4, BorderLayout.EAST);
        panel4.add(returnBtn);
        panel.setBackground(Color.WHITE);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.WHITE);
        panel4.setBackground(Color.WHITE);

        getContentPane().add(panel5, BorderLayout.CENTER);
        panel5.setLayout(null);

        panel5.add(commentTxt);
        commentTxt.setBounds(130, 160, 200, 20);
        panel5.add(commentTxt1);
        commentTxt1.setBounds(130, 330, 200, 20);
        panel5.add(Avatar1);
        Avatar1.setBounds(20, 20, 70, 70);
        panel5.add(AvatarBtn1);
        AvatarBtn1.setBounds(20, 20, 70, 70);
        panel5.add(Avatar2);
        Avatar2.setBounds(20, 200, 70, 70);
        panel5.add(AvatarBtn2);
        AvatarBtn2.setBounds(20, 200, 70, 70);
        panel5.add(textArea);
        textArea.setBounds(120, 20, 400, 120);
        panel5.add(textArea1);
        textArea1.setBounds(120, 200, 400, 120);


        panel5.add(Jdianzan);
        Jdianzan.setBounds(360, 160, 40, 30);
        panel5.add(likeBtn);
        likeBtn.setBounds(400, 160, 40, 30);
        panel5.add(likeBtn1);
        panel5.add(Jdianzan1);
        Jdianzan1.setBounds(360, 330, 40, 30);
        likeBtn1.setBounds(400, 330, 40, 30);
        panel5.add(commentBtn);
        commentBtn.setBounds(450, 160, 100, 30);
        panel5.add(commentBtn1);
        commentBtn1.setBounds(450, 330, 100, 30);
        panel5.add(bg);
        bg.setBounds(0, 0, 600, 600);

        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\images\\logo.jpg");
        this.setIconImage(icon1);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());
        fans();
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new ClientUserGroup();
    }

    public void fans() {
        try {
            // 获得连接
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/MySql?user=root&password=1234characterEncoding=GBK&useSSL=false";
            Connection con = DriverManager.getConnection(url);
            stat = (Statement) con.createStatement();
            url = "use java_wechat";
            System.out.println("连接成功");
            stat.executeUpdate(url);

            //朋友圈获取登陆的id
            String sql2 = "select UserName from user WHERE uid='1000'";
            PreparedStatement pstm2 = con.prepareStatement(sql2);
            ResultSet rs2 = pstm2.executeQuery();
            while (rs2.next()) {
                String a = rs2.getString("UserName");
                nameLb.setText(a);
            }
            String sql3 = "select uid,ucontent,time from circle_of_friends WHERE uid='1000'";
            PreparedStatement pstm3 = con.prepareStatement(sql3);
            ResultSet rs3 = pstm3.executeQuery();
            while (rs3.next()) {
                String a = rs3.getString("uid");
                String b = rs3.getString("ucontent");
                String c = rs3.getString("time");
                textArea1.setText(a + "\n" + b + "\n" + c);
            }

            String sql = "select uid,ucontent,time from circle_of_friends WHERE uid='1001";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String a = rs.getString("uid");
                String b = rs.getString("ucontent");
                String c = rs.getString("time");
                textArea.setText(a + "\n" + b + "\n" + c);
            }

            pstm.executeUpdate();

        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException sqle) {
            //JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }

    ;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(likeBtn1)) {
            try {
                // 获得连接
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/MySql?user=root&password=1234characterEncoding=GBK&useSSL=false";
                Connection con = DriverManager.getConnection(url);
                stat = (Statement) con.createStatement();
                url = "use weichat";
                System.out.println("连接成功");
                stat.executeUpdate(url);

                // 建立查询条件
                String sql = "update circle_of_friends set dianzan = dianzan+1 where uid='1000'";
                PreparedStatement pstm = con.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    String a = rs.getString("dianzan");

                    Jdianzan1.setText(a);


                }
                pstm.executeUpdate();
            } catch (ClassNotFoundException cnfe) {
                JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException sqle) {
                //JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource().equals(UpdatedBtn)) {
            //new ClientUserSendGroup();
            this.dispose();
        }
        if (e.getSource().equals(commentBtn)) {
            try {
                // 获得连接
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/MySql?user=root&password=1234";
                Connection con = DriverManager.getConnection(url);
                stat = (Statement) con.createStatement();
                url = "use weichat";
                System.out.println("连接成功");
                stat.executeUpdate(url);

                // 建立查询条件
                String sql = "insert into circle of friends(comment,comment_id ) VALUE(?,1000)";
                PreparedStatement pstm = con.prepareStatement(sql);

                // 执行查询
                ResultSet rs = pstm.executeQuery();
                // 计算有多少条记录
                pstm.setString(1, commentTxt.getText());


                pstm.executeUpdate();

            } catch (ClassNotFoundException cnfe) {
                JOptionPane.showMessageDialog(null, "数据源错误", "错误", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException sqle) {
                //JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
            }
        }


        if (e.getSource() == returnBtn) {
            // new ClientUserMainFrame();
            this.dispose();
        }
        if (e.getSource() == AvatarBtn) {
            //  new ClientUserMessage();
            this.dispose();
        }


    }
}
