package Client.JFrame.company;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ClientCompanyMainFrame extends JFrame implements ActionListener {
    public static Statement stat;
    JScrollPane scpDemo;
    private JTableHeader jth;
    private JTable tabDemo;
    JLabel Avatar =  new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\头像6.png"));
    JLabel nameLb = new JLabel();
    JLabel psLb = new JLabel("personal signature");
    JLabel fansLb = new JLabel("粉丝数：");
    JTextField fansTxt = new JTextField(15);
    JLabel Avatar1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\timg.jpg"));
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
    private Object rsl;
    private AbstractButton nameLa;
    Connection con;
    String getid = ClientUserLoginFrame.nameTxt.getText();
    int id =Integer.parseInt(getid);

    public ClientCompanyMainFrame (){
        this.setTitle("WeChat");
        this.returnBtn.addActionListener(this);
        //this.NewfriendsBtn.addActionListener(this);
        this.AvatarBtn.addActionListener(this);
        this.NewsBtn.addActionListener(this);
        this.selectBtn.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,600);

        panel.setBorder(BorderFactory.createTitledBorder("企业登陆面"));
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.add(AvatarBtn, BorderLayout.WEST);
        AvatarBtn.setPreferredSize(new Dimension(70,70));
        //Avatar.setText("Avatar");
        panel.add(Avatar, BorderLayout.WEST);
        Avatar.setPreferredSize(new Dimension(70,70));


        panel.add(panel1, BorderLayout.CENTER);
        panel1.setLayout(null);
        panel1.add(nameLb);
        nameLb.setBounds(10, 10, 50, 20);
        panel1.add(psLb);
        psLb.setBounds(10, 50, 500, 20);
        panel1.add(fansLb);
        fansLb.setBounds(210, 50, 500, 20);
        panel1.add(fansTxt);
        fansTxt.setBounds(252, 45, 35, 25);
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
        scpDemo = new JScrollPane();
        scpDemo.setBounds(10, 10, 370, 360);
        panel5.add(scpDemo);

        // panel5.add(textArea);
        // textArea.setBounds(0, 0, 400, 400);




        Image icon1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\asus\\Desktop\\Final-test-1.0\\src\\Images\\logo.jpg");
        this.setIconImage(icon1);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(getOwner());
        fans();

    }
    public static void main (String[] args){
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
        new ClientCompanyMainFrame();
    }

    //显示粉丝人数，头像，姓名
    public  void fans(){

        try{
            // 获得连接
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/MySql?user=root&password=1234";
            Connection con=DriverManager.getConnection(url);
            stat=con.createStatement();
            url="use java_wechat";
            System.out.println("连接成功");
            stat.executeUpdate(url);

            //统计关注企业的人数
            String sql1 = "select COUNT(DISTINCT uid)from company_user WHERE cid='"+id+"'";
            PreparedStatement pstm1 = con.prepareStatement(sql1);
            ResultSet rs1 = pstm1.executeQuery();
            while(rs1.next()){
                String a=rs1.getString(1);
                fansTxt.setText(a);
            }


            String sql2 = "select cpicture, cname from company WHERE cid='"+id+"'";
            PreparedStatement pstm2 = con.prepareStatement(sql2);
            ResultSet rs2 = pstm2.executeQuery();
            while(rs2.next()){
                String a=rs2.getString("cname");

                String b=rs2.getString("cpicture");
                nameLb.setText(a);
                //AVatar 是放图片的JLabel
                Avatar=new JLabel(new ImageIcon(b));
            }

            pstm2.executeUpdate();

        }catch(ClassNotFoundException cnfe){
            JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException sqle){
            //JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    };


    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(selectBtn)) {
            try{
                // 获得连接
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/MySql?user=root&password=1234";
                Connection con=DriverManager.getConnection(url);
                stat=con.createStatement();
                url="use java_wechat";
                System.out.println("连接成功");
                stat.executeUpdate(url);

                // 建立查询条件
                String sql = "select c_title,c_content,c_time from company_message where c_sendid='"+id+"'";
                PreparedStatement pstm = con.prepareStatement(sql);

                // 执行查询
                ResultSet rs = pstm.executeQuery();
                // 计算有多少条记录
                int count = 0;
                while(rs.next()){
                    count++;
                }
                rs = pstm.executeQuery();
                // 将查询获得的记录数据，转换成适合生成JTable的数据形式

                Object[][] info = new Object[count][3];
                count = 0;
                while(rs.next()){
                    info[count][0] =  rs.getString("c_title");
                    info[count][1] = rs.getString("c_content");
                    info[count][2] = rs.getString("c_time");
                    count++;
                }

                // 定义表头
                String[] title = {"公告标题","公告内容","发布时间"};
                // 创建JTable
                this.tabDemo = new JTable(info,title);
                // 显示表头
                this.jth = this.tabDemo.getTableHeader();
                // 将JTable加入到带滚动条的面板中
                this.scpDemo.getViewport().add(tabDemo);



                pstm.executeUpdate();

            }catch(ClassNotFoundException cnfe){
                JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
            }catch(SQLException sqle){
                //JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
            }
        }


        if(e.getSource()==returnBtn){
            new ClientUserLoginFrame();
            this.dispose();
        }
        if(e.getSource()==AvatarBtn){
          //  new ClientUserMessage();
            this.dispose();
        }


        if(e.getSource()==NewsBtn){
            new ClientCompangSendUessage();
            this.dispose();
        }

    }
    private void While(boolean next) {


    }
}
