package Client.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import Client.JFrame.client.StartClient;
import Client.JFrame.server.LookForUser;
import Client.JFrame.server.MyServerSocket;
import Client.JFrame.server.UserMessage.ShowUserMessageFrame.ShowUserMessageFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ClientUserMainFrame extends JFrame implements ActionListener {
    JLabel Avatar = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\头像6.png"));
    JLabel nameLb = new JLabel("ID");
    //JLabel psLb = new JLabel("personal signature");
    JLabel bg = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\bg3.jpg"));
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JTabbedPane tabbedPane = new JTabbedPane();
    JButton selectBtn = new JButton("朋友圈");
    JButton NewfriendsBtn = new JButton("+好友");
    JButton NewcompanyBtn = new JButton("+企业");
    JButton DeleteBtn = new JButton("删除");
    JButton returnBtn = new JButton("退出");
    JButton AvatarBtn = new JButton("头像按钮");
    JButton informationBtn = new JButton("个人信息");
    JButton chatroomBtn = new JButton("聊天室");
    ImageIcon icon = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\timg1.jpg");
    ImageIcon icon1 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\5.png");
    ImageIcon icon2 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\7.png");
    ImageIcon icon3 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\8.png");
    ImageIcon icon4 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\4.png");
    ImageIcon icon5 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\13.png");
    ImageIcon icon6 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\9.png");
    ImageIcon icon7 = new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\2.png");

    JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();

    JButton friendsBtn = new JButton("好友");
    JButton friendsBtn1 = new JButton("好友1");
    JButton friendsBtn2 = new JButton("好友2");
    JButton friendsBtn3 = new JButton("好友3");
    JButton friendsBtn4 = new JButton("好友4");
    JButton friendsBtn5 = new JButton("好友5");
    JButton friendsBtn6 = new JButton("好友6");
    JButton friendsBtn7 = new JButton("好友7");
    JButton friendsBtn8 = new JButton("好友8");
    JButton friendsBtn9 = new JButton("好友9");
    JButton friendsBtn10 = new JButton("好友10");
    JButton friendsBtn11 = new JButton("好友11");

    JButton groupChatBtn = new JButton("群聊");
    JTextArea textArea = new JTextArea();


    //Object title[] = {"企业名","关注人数"};
    //Object detail[][]={{"abc","18"},
    //{"kkk","19"},
    //{"xxx","20"},
    //{"fff","21"}};
    //JTable table = new JTable(detail,title);
    //JTableHeader head=table.getTableHeader();

    public ClientUserMainFrame (String a,String b){
        this.setTitle("WeChat");
        this.nameLb=new JLabel("用户名："+a);
        this.returnBtn.addActionListener(this);
        this.selectBtn.addActionListener(this);
        this.NewfriendsBtn.addActionListener(this);
        this.NewcompanyBtn.addActionListener(this);
        this.AvatarBtn.addActionListener(this);
        this.friendsBtn.addActionListener(this);
        this.groupChatBtn.addActionListener(this);
        this.informationBtn.addActionListener(this);
        this.chatroomBtn.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);

        AvatarBtn.setIcon(icon);
        selectBtn.setIcon(icon1);
        NewfriendsBtn.setIcon(icon2);
        NewcompanyBtn.setIcon(icon3);
        DeleteBtn.setIcon(icon4);
        returnBtn.setIcon(icon5);
        groupChatBtn.setIcon(icon6);
        informationBtn.setIcon(icon7);
        chatroomBtn.setIcon(icon6);
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.add(AvatarBtn, BorderLayout.WEST);
        AvatarBtn.setPreferredSize(new Dimension(70,70));
        //Avatar.setText("Avatar");
        //panel.add(Avatar, BorderLayout.WEST);
        //Avatar.setPreferredSize(new Dimension(70,70));
        AvatarBtn.setContentAreaFilled(false);

        panel.add(panel1, BorderLayout.CENTER);
        panel1.setLayout(null);
        panel1.add(nameLb);
        nameLb.setBounds(10, 10, 200, 20);
        //panel1.add(psLb);
        //psLb.setBounds(10, 50, 500, 20);
        panel1.add(informationBtn);
        informationBtn.setBounds(400, 20, 120, 40);
        panel1.add(selectBtn);
        selectBtn.setBounds(270, 20, 110, 40);
        panel1.add(bg);
        bg.setBounds(0, 0, 700, 200);




        panel2.setLayout(new BorderLayout());
        getContentPane().add(panel2, BorderLayout.SOUTH);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel3.setLayout(flowLayout);
        panel2.add(panel3);
        panel2.add(panel4, BorderLayout.EAST);
        panel3.add(chatroomBtn);
        selectBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        selectBtn.setHorizontalAlignment(SwingConstants.LEFT);
        panel3.add(groupChatBtn);
        panel3.add(NewfriendsBtn);
        panel3.add(NewcompanyBtn);
        panel3.add(DeleteBtn);
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
        panel7.setBackground(Color.WHITE);

        tabbedPane.addTab("好友列表", null, scrollPane, null);
        tabbedPane.addTab("公告", null, scrollPane1, null);
        //tabbedPane.addTab("企业列表", null, scrollPane2, null);

        scrollPane.setViewportView(panel5);
        panel5.setLayout(new GridLayout(20, 1, 10, 10));
        panel5.add(friendsBtn);
        panel5.add(friendsBtn1);
        panel5.add(friendsBtn2);
        panel5.add(friendsBtn3);
        panel5.add(friendsBtn4);
        panel5.add(friendsBtn5);
        panel5.add(friendsBtn6);
        panel5.add(friendsBtn7);
        panel5.add(friendsBtn8);
        panel5.add(friendsBtn9);
        panel5.add(friendsBtn10);
        panel5.add(friendsBtn11);

        scrollPane1.setViewportView(textArea);

        //scrollPane2.setViewportView(panel7);
        //panel7.setLayout(new BorderLayout());
        //panel7.add(table,BorderLayout.CENTER);
        //panel7.add(head,BorderLayout.NORTH);


        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\logo.jpg");
        this.setIconImage(icon1);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());
//        String e;
//        e=a;
        informationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String f=a;
                String g=b;
                String c=null;
                String d=null;
                new ShowUserMessageFrame(f,g,c,d);
            }
        });
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ClientUserLoginFrame();
            }
        });
        chatroomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientFrom(a,b);
            }
        });
        selectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientUserGroup();
            }
        });
        NewfriendsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LookForUser();
            }
        });
        groupChatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyServerSocket();
                new StartClient();
            }
        });
    }
    public static void main (String[] args){
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //new ClientUserMainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==selectBtn){
//            new ClientUserGroup();
//            this.dispose();
//        }
//
//
//        if(e.getSource()==NewfriendsBtn){
//            new ClientLookForUser();
//            this.dispose();
//        }
//        if(e.getSource()==NewcompanyBtn){
//            new ClientLookForCompany();
//            this.dispose();
//        }
//        if(e.getSource()==returnBtn){
//            new ClientUserLoginFrame();
//            this.dispose();
//        }
//        if(e.getSource()==AvatarBtn){
//            new ClientUserMessage();
//            this.dispose();
//        }
//        if(e.getSource()==friendsBtn){
//            new ClientUserSendMessage();
//            this.dispose();
//        }
//        if(e.getSource()==groupChatBtn){
//            new ClientUserSendMessage();
//            this.dispose();
//        }
//        if(e.getSource()==chatroomBtn){
//            new ClientUserSendMessage();
//            this.dispose();
//        }
//        if(e.getSource()==informationBtn){
//            new ClientUserMessage();
//            this.dispose();
//        }
//        this.dispose();
//    }
}
