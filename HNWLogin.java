

import Client.JFrame.ClientUserLoginFrame;
import Client.JFrame.ServerFrom;
import Client.JFrame.company.ClientCompanyLoginFrame;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

public class HNWLogin extends JFrame implements ActionListener {
    private JLayeredPane layeredPane;
    private JPanel jp;
    private JLabel jl;//放背景图片的
    private ImageIcon image;
    private JButton EnterBtn;
    private JButton AddUserBtn;
    public HNWLogin(){
        super("Hello New World");//标题
        String path="/Images/logo.jpg";//图标
        //获取图标信息
        try {
            Image img=ImageIO.read(this.getClass().getResource(path));
            this.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //存储背景的面板
        layeredPane=new JLayeredPane();
        image=new ImageIcon("C:\\Users\\asus\\Desktop\\HelloNewWorldJFrame\\src\\Img\\background.jpeg");//随便找一张图就可以看到效果。
        //创建背景的那些东西
        jp=new JPanel();
        jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
        jl=new JLabel(image);
        jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
        jp.add(jl);
//        this.UserNameLb=new JLabel("用户名：");
//        this.UserNameLb.setBounds(120,30,100,30);
//        UserNameLb.setFont(new Font("宋体",Font.PLAIN,16));
//        this.UserNameTxt=new JTextField(15);
//        this.UserNameTxt.setBounds(220,30,100,30);
//        this.UserPassWordLb=new JLabel("密  码：");
//        this.UserPassWordLb.setBounds(120,100,100,30);
//        UserPassWordLb.setFont(new Font("宋体",Font.PLAIN,16));
//        this.UserPassWordTxt=new JTextField(15);
//        this.UserPassWordTxt.setBounds(220,100,100,30);
        this.EnterBtn=new JButton("个人用户登陆");
        this.EnterBtn.setBounds(200,520,150,30);
        this.EnterBtn.setBackground(Color.gray);
        this.AddUserBtn=new JButton("企业用户登陆");
        this.AddUserBtn.setBounds(500,520,150,30);
        this.AddUserBtn.setBackground(Color.gray);
        //将jp放到最底层。
        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
        //将jb放到高一层的地方
        layeredPane.add(EnterBtn,JLayeredPane.MODAL_LAYER);
        layeredPane.add(AddUserBtn,JLayeredPane.MODAL_LAYER);
        this.setLayeredPane(layeredPane);
        this.setSize(image.getIconWidth(),image.getIconHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(image.getIconWidth(),image.getIconHeight());
        this.setLocation(150,150);
        this.setVisible(true);
        this.setResizable(false);
        EnterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //new UserLogin();
                new ClientUserLoginFrame();
            }
        });
        AddUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //new AddNewUserTo();
                new ClientCompanyLoginFrame();
            }
        });
    }
    public static void main(String[]args){
//        try {
//            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        new ServerFrom();
        new HNWLogin();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
