package Client.JFrame.company;


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
import java.sql.ResultSet;
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

public class ClientCompangSendUessage extends JFrame implements ActionListener {
    public static Statement stat;
    JLabel Avatar = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\头像6.png"));
    JLabel Avatar1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\bg3.jpg"));
    JLabel nameLb = new JLabel();
    //JLabel psLb = new JLabel("personal signature");
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    JSplitPane splitPane = new JSplitPane();
    JButton ExpressionpackageBtn = new JButton("内容");
    JButton sendBtn = new JButton("发送");
    JButton cancelBtn = new JButton("取消");
    JButton AvatarBtn = new JButton("头像按钮");
    JTextArea textArea = new JTextArea();
    JTextArea textArea1 = new JTextArea();
    FlowLayout flowLayout = new FlowLayout();
    FlowLayout flowLayout1 = new FlowLayout();
    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane1 = new JScrollPane();
    ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\13.png");
    ImageIcon icon1 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\9.png");
    ImageIcon icon2 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\17.png");
    String getid = ClientUserLoginFrame.nameTxt.getText();
    int id = Integer.parseInt(getid);



    public ClientCompangSendUessage (){
        this.setTitle("WeChat");
        this.cancelBtn.addActionListener(this);
        this.sendBtn.addActionListener(this);
        //sendBtn.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);

        ExpressionpackageBtn.setIcon(icon2);
        sendBtn.setIcon(icon1);
        cancelBtn.setIcon(icon);
        panel.setBorder(BorderFactory.createTitledBorder("企业发布信息"));
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

        splitPane.setDividerLocation(40);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        getContentPane().add(splitPane, BorderLayout.CENTER);

        panel2.setLayout(new BorderLayout());
        splitPane.setRightComponent(panel2);
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel3.setLayout(flowLayout);
        panel2.add(panel3, BorderLayout.NORTH);
        panel3.add(ExpressionpackageBtn);

        flowLayout1.setAlignment(FlowLayout.RIGHT);
        panel4.setLayout(flowLayout1);
        panel2.add(panel4, BorderLayout.SOUTH);

        panel4.add(sendBtn);
        panel4.add(cancelBtn);
        panel2.add(scrollPane, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);

        panel4.setBackground(Color.WHITE);

        scrollPane.setViewportView(textArea1);
        scrollPane1.setViewportView(textArea);
        splitPane.setLeftComponent(scrollPane1);

        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\logo.jpg");
        this.setIconImage(icon1);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());
        fans();

    }

    public static void main (String[] args){
//        try {
//           // BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        new ClientCompangSendUessage();
    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource().equals(sendBtn)) {
            if (textArea.getText().equals(""))
                JOptionPane.showMessageDialog(null, "请输入标题！");
            else if (textArea1.getText().equals(""))
                JOptionPane.showMessageDialog(null, "请输入内容！");
            else if (textArea.getText().length() != 0
                    && textArea1.getText().length() != 0) {
                try{
                    // 获得连接
                    Class.forName("com.mysql.jdbc.Driver");
                    String url="jdbc:mysql://localhost:3306/MySql?user=root&password=1234";
                    Connection con=DriverManager.getConnection(url);
                    stat=(Statement) con.createStatement();
                    url="use weichat";
                    System.out.println("连接成功");
                    stat.executeUpdate(url);

                    // 建立查询条件
                    StringBuilder sb = new StringBuilder();

                    sb.append("INSERT INTO company_message(c_title,c_content,c_time,c_sendid) VALUE(\'");
                    sb.append(textArea.getText()+"\',\'");
                    sb.append(textArea1.getText()+"\',");
                    sb.append("now(),\'");

                    //账号获取不了，用2000
                    sb.append("2000\');");
                    PreparedStatement pstm = con.prepareStatement(sb.toString());
                    System.out.println(sb);
                    JOptionPane.showMessageDialog(null, "发布成功！");
                    this.dispose();
                    new ClientCompanyMainFrame();
                }catch(ClassNotFoundException cnfe){
                    JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
                }catch(SQLException sqle){
                    JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        if(e.getSource()==cancelBtn){
            new ClientCompanyMainFrame();
            this.dispose();
        }

    }
    public  void fans(){
        try{
            // 获得连接
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/MySql?user=root&password=1234";
            Connection con=DriverManager.getConnection(url);
            stat=(Statement) con.createStatement();
            url="use weichat";
            System.out.println("连接成功");
            stat.executeUpdate(url);


            String sql2 = "select cpicture, cname from company WHERE cid='"+id+"'";
            PreparedStatement pstm2 = con.prepareStatement(sql2);
            ResultSet rs2 = pstm2.executeQuery();
            while(rs2.next()){
                String a=rs2.getString("cname");
                String b=rs2.getString("cpicture");
                nameLb.setText(a);

                Avatar.setText(b);
            }

            pstm2.executeUpdate();

        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    };
    private String getDate() {
        // TODO Auto-generated method stub
        return String.valueOf(System.currentTimeMillis());
    }
}
