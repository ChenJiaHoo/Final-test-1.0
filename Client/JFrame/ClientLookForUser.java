//package Client.JFrame;
//
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.sql.SQLException;
//import javax.swing.*;
//
//import Client.JFrame.ClientFunction.ConnectMysql.ConnectMysql;
//import Client.JFrame.ClientFunction.ConnectMysql.JDBC1;
//import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
//
//import static Client.JFrame.ClientFunction.ConnectMysql.ConnectMysql.Addconfirm;
////import static Client.JFrame.ClientFunction.ConnectMysql.ConnectMysql.SearchFriends;
//
//public class ClientLookForUser extends JFrame implements ActionListener,KeyListener {
//    public static JTable table;
//    public static JScrollPane jScrollPane;
//    public static JPanel jPanel;
//    public static JTextField JTex;
//
//    JPanel Panel1 = new JPanel(new FlowLayout());
//    JLabel  JLabel= new JLabel("输入用户id：");
//    JButton JBt = new JButton("返回");
//    JButton JBt1 = new JButton("搜索");
//    JButton JBt2 = new JButton("添加好友");
//
//
//
//    ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\13.png");
//    ImageIcon icon1 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\7.png");
//    ImageIcon icon2 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\20.png");
//
//    public ClientLookForUser(){
//        jPanel=new JPanel();
//        JTex = new JTextField(20);
//        this.setTitle("WeChat");
//        this.setSize(610,610);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JBt.setIcon(icon);
//        JBt1.setIcon(icon1);
//        JBt2.setIcon(icon2);
//
//        this.add(jPanel);
//        Panel1.add(JLabel);
//        Panel1.add(JTex);
//        Panel1.add(JBt1);
//        jPanel.add(Panel1,BorderLayout.NORTH);
//
//        jPanel.add(JBt, new FlowLayout());
//        jPanel.add(JBt2, new FlowLayout());
//        JBt.addActionListener(this);
//        JBt1.addActionListener(this);
//        JBt2.addActionListener(this);
//        jPanel.setBackground(Color.WHITE);
//        Panel1.setBackground(Color.WHITE);
//        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\logo.jpg");
//        this.setIconImage(icon1);
//        this.setResizable(false);
//        this.setVisible(true);
//        this.setLocationRelativeTo(null);
//
//
//    }
//    public static void main(String[] args) {
//        try {
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        new ClientLookForUser();
//    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource().equals(JBt1)) {
//            if (JBt1.getText().equals("")) {
//                JOptionPane.showMessageDialog(this, "请输入搜索的账号");
//
//            }
//            else {
//               JDBC1.getConnection();
//                try {
//                    SearchFriends();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//
//        if (e.getSource().equals(JBt2)) {
//           JDBC1.getConnection();
//            try {
//               Addconfirm();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }
//
//
//        if(e.getSource()==JBt){
//           // new ClientUserMainFrame();
//            this.dispose();
//        }
//
//
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        if(e.getKeyChar()==KeyEvent.VK_ENTER){
//            if (JTex.getText().equals("")) {
//                JOptionPane.showMessageDialog(this, "请输入搜索的账号");
//            }
//            else{
//                JDBC1.getConnection();
//                try {
//                    SearchFriends();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//
//    }
//
//}
