package Client.JFrame;

import Client.JFrame.ClientFunction.CutImage.CaptureScreen;
import Client.JFrame.ClientFunction.FileSend.UI.SocketFileJFrame;
import Client.JFrame.server.UserMessage.ShowUserMessageFrame.ShowUserMessageFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;




public class ClientFrom extends JFrame implements ActionListener{
    private static String ip="10.11.144.157";
    private static int port=81;

    private JTextField tfdUserName=new JTextField(10);  //用户标识
    private JTextPane allMsg=new JTextPane();   //聊天信息显示
    private JTextField tfdMsg=new JTextField(20);//发送消息消息框
    private JButton btnSend;    //发送消息按钮
    private JButton btnCon;//连接按钮
    private JButton btnEmo;//表情包按钮
    private JButton btnWithdraw;//撤回消息按钮
    private JButton btnInfo;//个人信息按钮
    private JButton SendFileBtn;
    private JButton CutImageBtn;



    //在线用户列表
    private DefaultListModel<String> dataModel=new DefaultListModel<String>();
    private JList<String> list=new JList<String>(dataModel);


    public ClientFrom(String a,String b) {
        setBounds(600,300,600,530);

        addMenuBar();   //添加菜单
        ////////////////////上方面板/////////////
        JPanel northPanel=new JPanel();
        northPanel.add(new JLabel("用户名称"));
        tfdUserName.setText(a);
        northPanel.add(tfdUserName);

        btnCon=new JButton("连接");
        btnCon.setActionCommand("c");
        JButton btnExit=new JButton("退出");
//        btnExit.setActionCommand("exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        northPanel.add(btnCon);
        northPanel.add(btnExit);
        getContentPane().add(northPanel,BorderLayout.NORTH);    //放在上方


        //////////////////中间面板////////////////
        JPanel centerPanel=new JPanel(new BorderLayout());
        //中
        btnEmo=new JButton("表情包");
        btnEmo.setActionCommand("emoji");
        btnEmo.setBounds(100,310,80,20);
        this.add(btnEmo);
        btnEmo.setEnabled(true);

        btnWithdraw=new JButton("撤回");
        btnWithdraw.setActionCommand("withdraw");
        btnWithdraw.setBounds(200,310,80,20);
        this.add(btnWithdraw);
        btnWithdraw.setEnabled(true);



        SendFileBtn=new JButton("发送文件");
        SendFileBtn.setBounds(300,310,90,20);
        this.add(SendFileBtn);
        SendFileBtn.setEnabled(true);

        CutImageBtn=new JButton("截图");
        CutImageBtn.setBounds(520,310,60,20);
        this.add(CutImageBtn);
        CutImageBtn.setEnabled(true);

        btnInfo=new JButton("个人信息");
        btnInfo.setBounds(410,310,100,20);
        btnInfo.setActionCommand("info");
        this.add(btnInfo);
        btnInfo.setEnabled(true);

        allMsg=new JTextPane();
        allMsg.setEditable(false);
        allMsg.setForeground(Color.blue);
        allMsg.setFont(new Font("幼圆", Font.BOLD, 14));
        allMsg.setBounds(100,50,480,250);
        this.add(allMsg);

        //西
        dataModel.addElement("全部");
        list.setSelectedIndex(0);   //设置默认选择位置
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);    //设置只能单选
        list.setVisibleRowCount(5);     //设置显示的行数
        list.setFont(new Font("幼圆", Font.BOLD, 12));

        JScrollPane scroll=new JScrollPane(list);       //为list添加滚动条
        scroll.setBorder(new TitledBorder("在线"));   //Border的实现类TitileBorder
        scroll.setPreferredSize(new Dimension(70, allMsg.getHeight())); //设置滚动条的首选大小
        scroll.setBounds(10,40,80,350);
        this.add(scroll);


        //南
        JPanel southPanel=new JPanel();
        tfdMsg.setBounds(100,335,480,100);
        this.add(tfdMsg);

        btnSend=new JButton("发送");
        btnSend.setActionCommand("send");
        btnSend.setEnabled(true);
        southPanel.add(btnSend);
        btnSend.setBounds(320,400,100,50);
        centerPanel.add(southPanel,BorderLayout.SOUTH);


        //把中间面板加到框架中
        getContentPane().add(centerPanel);

        //事件监听
        btnCon.addActionListener(this);
        btnExit.addActionListener(this);
        btnSend.addActionListener(this);
        btnInfo.addActionListener(this);
        btnEmo.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(tfdUserName.getText()==null || tfdUserName.getText().trim().length()==0){
                    int result = JOptionPane.showConfirmDialog(ClientFrom.this, "你还没登录,是否退出");
                    if(result==JOptionPane.YES_OPTION){
                        System.exit(0);
                    }else{
                        return;
                    }
                }
                System.out.println(tfdUserName.getText()+"退出");
                sendExitMsg();
                System.exit(0);
            }
        });

        setVisible(true);
        setResizable(false);





        SendFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SocketFileJFrame frame = new SocketFileJFrame();
                  frame.setVisible(true);
            }
        });

        CutImageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CaptureScreen();
            }
        });
        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c=null;
                String d=null;
                new ShowUserMessageFrame(a,b,c,d);
            }
        });




    }




    private void addMenuBar() {
        JMenuBar menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu=new JMenu("选项");
        menuBar.add(menu);

        JMenuItem itemSet=new JMenuItem("设置");
        JMenuItem itemHelp=new JMenuItem("帮助");

        itemSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JDialog setDlg=new JDialog(ClientFrom.this);
                setDlg.setBounds(ClientFrom.this.getX(), ClientFrom.this.getY(), 250, 100);
                setDlg.setLayout(new FlowLayout());
                setDlg.add(new JLabel("服务器:"));
                final JTextField tfdIP=new JTextField(10);
                tfdIP.setText(ip);
                setDlg.add(tfdIP);
                setDlg.add(new JLabel("端口:"));
                final JTextField tfdPort=new JTextField(10);
                tfdPort.setText(port+"");
                setDlg.add(tfdPort);

                JButton btnSet=new JButton("设置");
                btnSet.setActionCommand("set");
                JButton btnCanel=new JButton("取消");
                btnCanel.setActionCommand("canel");
                setDlg.add(btnSet);
                setDlg.add(btnCanel);

                btnSet.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if("set".equals(e.getActionCommand())){
                            if(tfdIP.getText()!=null && tfdIP.getText().trim().length()>0){
                                ClientFrom.this.ip=tfdIP.getText();
                            }
                            if(tfdPort.getText()!=null && tfdPort.getText().trim().length()>0){
                                try {
                                    ClientFrom.this.port=Integer.parseInt(tfdPort.getText());
                                } catch (NumberFormatException e1) {
                                    JOptionPane.showMessageDialog(setDlg, "端口号格式输入错误,请输入数字");
                                }
                            }
                            btnCon.setEnabled(true);
                            tfdUserName.setEditable(true);
                            if(client!=null){
                                //如果前面已经登录着用户,就把用户退出
                                String msg="exit@#全部@#null@#"+tfdUserName.getText();
                                pw.println(msg);
                                dataModel.removeElement(tfdUserName.getText());
                                list.validate();
                                tfdUserName.setText("");
                            }

                            setDlg.dispose();
                        }else if("canel".equals(e.getActionCommand())){
                            return;
                        }
                    }
                });
                setDlg.setVisible(true);
            }
        });

        itemHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog helpDlg = new JDialog(ClientFrom.this);
                helpDlg.setBounds(ClientFrom.this.getX()+10, ClientFrom.this.getY(), 300, 100);
                JLabel str = new JLabel();
                helpDlg.add(str);
                helpDlg.setVisible(true);
            }
        });

        menu.add(itemSet);
        menu.add(itemHelp);

    }





    @Override

    public void actionPerformed(ActionEvent e) {
        if("c".equals(e.getActionCommand())){
            System.out.println(tfdUserName.getText());

            if(tfdUserName.getText()==null || tfdUserName.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this, "用户名不能为空");
                return;
            }
            System.out.println(tfdUserName.getText()+":连接ing...");
            connecting();
        }else if("exit".equals(e.getActionCommand())){
            if(tfdUserName.getText()==null || tfdUserName.getText().trim().length()==0){
                int result = JOptionPane.showConfirmDialog(this, "你还没登录,是否退出");
                if(result==JOptionPane.YES_OPTION){
                    System.exit(0);
                }else{
                    return;
                }
            }
            System.out.println(tfdUserName.getText()+"退出");
            sendExitMsg();
        }else if("send".equals(e.getActionCommand())){
            if(tfdMsg.getText()==null){
                JOptionPane.showMessageDialog(this, "发送消息不能为空");
                return;
            }
            Date d=new Date();//获取当前时间
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss") ;
            String msg="on@#"+list.getSelectedValue()+"@#"+tfdMsg.getText()+ "       "+sdf.format(d)+"@#"+tfdUserName.getText();
            pw.println(msg);
        }//发送信息
        else if("info".equals(e.getActionCommand())){
            //new ClientUserInforamationFrame();
            //new ShowUserMessageFrame();
        }//跳转个人信息界面
        else if("emoji".equals(e.getActionCommand())){
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.showOpenDialog(ClientFrom.this);
            allMsg.insertIcon(new ImageIcon(chooser.getSelectedFile().toString()));
        }//发送图片
    }



    private Socket client;
    private PrintWriter pw;
    private void connecting() {
        //与服务器建立连接,把userName传给服务器
        try {
            client=new Socket(ip,port);
            //发送用户名给服务器
            btnCon.setEnabled(false);   //连接成功后关掉连接按钮
            String userName=tfdUserName.getText().trim();
            pw=new PrintWriter(client.getOutputStream(),true);
            pw.println(userName);
            //连接之后,设置标题为userName在线
            setTitle(userName+"在线");

            btnSend.setEnabled(true);       //打开发送按钮
            tfdUserName.setEditable(false);     //用户名不能再修改

            //开一个线程单独用于跟服务器通信
            new ClientThread(client).start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendExitMsg() {
        //与服务器建立连接,把userName传给服务器
        try {
            client=new Socket(ip, port);
            String msg="exit@#全部@#null@#"+tfdUserName.getText();
            pw.println(msg);

            System.exit(0);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    class ClientThread extends Thread{
        private Socket client;
        public ClientThread(Socket client) {
            this.client=client;
        }

        @Override
        public void run() {
            //接收服务器返回的信息
            Document docs=allMsg.getDocument();
            SimpleAttributeSet attrest=new SimpleAttributeSet();
            StyleConstants.setFontSize(attrest,16);


            try {
                Scanner sc=new Scanner(client.getInputStream());

                while(sc.hasNext()){
                    String msg=sc.nextLine();
                    String msgs[]=msg.split("@#");
                    if(msgs==null || msgs.length!=3){
                        System.out.println("通讯异常");
                        return;
                    }


                    if("msg".equals(msgs[0])){
                        //表示该信息是用来显示用的
                        if("server".equals(msgs[1])){
                            //表示该信息是系统信息
                            msg="系统信息:"+msgs[2];
                            docs.insertString(docs.getLength(),msg+"\r\n",attrest);
                            tfdMsg.setText(null);//发送信息后清空输入框
                        }else{
                            //表示该信息聊天信息
                            msg=msgs[1]+msgs[2];
                            docs.insertString(docs.getLength(),msg+"\r\n",attrest);
                            tfdMsg.setText(null);//发送信息后清空输入框
                        }
                    }else if("cmdAdd".equals(msgs[0])){
                        //表示该消息是用来更新用户在线列表的,添加用户
                        dataModel.addElement(msgs[2]);
                    }else if("cmdRed".equals(msgs[0])){
                        //表示该消息是用来更新用户在线列表的,移除用户
                        dataModel.removeElement(msgs[2]);
                    }
                    list.validate();    //需要刷新list，不然可能出现list更新失败的bug
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }


//    public static void main(String[] args) {
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        String a=null;
//        new ClientFrom(a);
//    }


}
