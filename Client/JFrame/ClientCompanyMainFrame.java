package Client.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ClientCompanyMainFrame extends JFrame implements ActionListener {
    JLabel Avatar = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\头像6.png"));
    JLabel nameLb = new JLabel("ID");
    //JLabel psLb = new JLabel("personal signature");
    JLabel fansLb = new JLabel("fans：");
    JTextField fansTxt = new JTextField(15);
    JLabel Avatar1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\bg3.jpg"));
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JTabbedPane tabbedPane = new JTabbedPane();
    JButton selectBtn = new JButton("刷新");
    JButton NewsBtn = new JButton("发公告");
    JButton returnBtn = new JButton("退出");
    JButton AvatarBtn = new JButton("头像按钮");
    JTextArea textArea = new JTextArea();
    ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\13.png");
    ImageIcon icon1 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\16.png");
    ImageIcon icon2 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\18.png");

    public ClientCompanyMainFrame (){
        this.setTitle("WeChat");
        this.returnBtn.addActionListener(this);
        this.NewsBtn.addActionListener(this);
        this.AvatarBtn.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,600);

        selectBtn.setIcon(icon2);
        NewsBtn.setIcon(icon1);
        returnBtn.setIcon(icon);
        panel.setBorder(BorderFactory.createTitledBorder("企业登陆面"));
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.add(AvatarBtn, BorderLayout.WEST);
        AvatarBtn.setPreferredSize(new Dimension(70,70));
        Avatar.setText("Avatar");
        panel.add(Avatar, BorderLayout.WEST);
        Avatar.setPreferredSize(new Dimension(70,70));


        panel.add(panel1, BorderLayout.CENTER);
        panel1.setLayout(null);
        panel1.add(nameLb);
        nameLb.setBounds(10, 10, 50, 20);
        //panel1.add(psLb);
        //psLb.setBounds(10, 50, 500, 20);
        panel1.add(fansLb);
        fansLb.setBounds(210, 50, 500, 20);
        panel1.add(fansTxt);
        fansTxt.setBounds(250, 50, 30, 20);
        panel1.add(Avatar1);
        Avatar1.setBounds(0, 0, 700, 200);



        panel2.setLayout(new BorderLayout());
        getContentPane().add(panel2, BorderLayout.SOUTH);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel3.setLayout(flowLayout);
        panel2.add(panel3);
        panel2.add(panel4, BorderLayout.EAST);
        panel3.add(selectBtn);
        selectBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        selectBtn.setHorizontalAlignment(SwingConstants.LEFT);
        panel3.add(NewsBtn);
        panel4.add(returnBtn);
        panel2.add(panel4, BorderLayout.EAST);
        panel.setBackground(Color.WHITE);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);



        FlowLayout flowLayout1 = new FlowLayout();
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        panel5.setBackground(Color.WHITE);
        panel6.setBackground(Color.WHITE);
        tabbedPane.setBackground(Color.WHITE);
        //panel7.setBackground(Color.WHITE);

        tabbedPane.addTab("公告列表", null, panel5, null);
        tabbedPane.addTab("粉丝列表", null, panel6, null);
        //tabbedPane.addTab("", null, panel7, null);
        panel5.setLayout(null);
        panel5.add(textArea);
        textArea.setBounds(0, 0, 400, 400);

        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\logo.jpg");
        this.setIconImage(icon1);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());

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
//        new ClientCompanyMainFrame();
//    }

    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==returnBtn){
            //new ClientUserLoginFrame();
            this.dispose();
        }
        if(e.getSource()==AvatarBtn){
            //new ClientUserMessage();
            this.dispose();
        }
        if(e.getSource()==NewsBtn){
            //new ClientCompangSendUessage();
            this.dispose();
        }
        this.dispose();
    }
}
