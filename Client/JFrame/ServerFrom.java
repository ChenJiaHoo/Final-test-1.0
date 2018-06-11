package Client.JFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class ServerFrom extends JFrame {

    private JTextArea area;//在线的用户信息显示
    private DefaultListModel<String> dataModel;   //在线的用户列表显示

    //注册的用户名不能相同
    //用于存储所有的用户,这里采用注册的"用户名"做key值,通信的socket做value值
    private Map<String, Socket> userMap = new HashMap<String, Socket>();

    public ServerFrom() {
        setTitle("聊天服务器");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int runWidth = 500;
        int runHeight = 400;
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();
        //设置界面居中显示
        setBounds(width / 2 - runWidth / 2, height / 2 - runHeight / 2, runWidth, runHeight);

        area = new JTextArea();
        area.setEditable(false);
        getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);

        //列表显示
        dataModel = new DefaultListModel<String>();
        JList<String> list = new JList<String>(dataModel);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBorder(new TitledBorder("在线"));
        scroll.setPreferredSize(new Dimension(100, this.getHeight()));
        getContentPane().add(scroll, BorderLayout.EAST);

        //菜单
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("控制(C)");
        menu.setMnemonic('C');      //设置快捷键为 Alt+C
        menuBar.add(menu);
        //开启
        final JMenuItem itemRun = new JMenuItem("开启");
        //快捷键 Ctrl+R
        itemRun.setAccelerator(KeyStroke.getKeyStroke('R', KeyEvent.CTRL_MASK));
        itemRun.setActionCommand("run");
        menu.add(itemRun);
        //退出
        JMenuItem itemExit = new JMenuItem("退出");
        itemExit.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_MASK));
        itemExit.setActionCommand("exit");
        menu.add(itemExit);

        itemRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("run".equals(e.getActionCommand())) {
                    startServer();
                    itemRun.setEnabled(false);
                }
            }
        });


        setVisible(true);
    }

    private void startServer() {
        try {
            System.out.println("服务器启动");
            ServerSocket server = new ServerSocket(81);
            area.append("启动服务器:" + server);

            //单独开启一个线程用于与客户端握手
            new ServerThread(server).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class ServerThread extends Thread {

        private ServerSocket server;

        public ServerThread(ServerSocket server) {
            this.server = server;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Socket s = server.accept();
                    //读取客户端第一次向服务器请求的信息
//                  BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
//                  if(br.readLine()!=null){
//                      String userName=br.readLine();
//                  }
                    Scanner sc = new Scanner(s.getInputStream());
                    if (sc.hasNext()) {
                        String userName = sc.next();
                        area.append("\r\n" + userName + "上线了。" + s);
                        dataModel.addElement(userName);
//                      userMap.put(userName, s);   //在后面在把这个用户加入到集合中好一点,那样发送上线信息给所有用户时,就不用判断不发发给自己了。

                        //登录成功
                        //在专门开一个线程用于跟针对某一个客户端通讯
                        //根据接收客户端发来的协议判断,客户端进行的是什么样的请求
                        new ClientThread(s).start();

                        //告诉其他用户有人上线了
                        sendMsgToAll(userName);
                        //把消息其他在线的用户的信息传给登录的这个客户端
                        sendMsgToSelf(s);

                        userMap.put(userName, s);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsgToAll(String userName) throws IOException {       //这里的异常可以抛,因为调用这个方法的位置抓了IOException
        //遍历map中所有除了该用户之外的客户--此时登录的用户还没有加入到容器中,所有可以直接遍历所有用户
        Iterator<Socket> it = userMap.values().iterator();
        while (it.hasNext()) {
            Socket s = it.next();
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            //服务器向客户端发的消息格式设计：
            //命令关键字@#发送方@#消息内容
            String msg = "msg@#server@#" + userName + "登录了";  //用于显示用的.
            pw.println(msg);
            msg = "cmdAdd@#server@#" + userName;    //用于给客户端维护在线用户列表用的
            pw.println(msg);

//          pw.close();
//          s.close();
        }
    }

    public void sendMsgToSelf(Socket s) throws IOException {

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        Iterator<String> it = userMap.keySet().iterator();
        while (it.hasNext()) {
            String userName = it.next();
            System.out.println("map:" + userMap);
            //告诉用户当前在线用户信息,不需要发送显示信息，只需要发送给客户端更新在线列表的信息
            String msg = "cmdAdd@#server@#" + userName;
            pw.println(msg);
        }

//      pw.close();
    }

    //专门用于跟某一个用户通讯的线程
    class ClientThread extends Thread {
        private Socket s;

        public ClientThread(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                //根据接收客户端发来的协议判断,客户端进行的是什么样的请求
                Scanner sc = new Scanner(s.getInputStream());
                while (sc.hasNextLine()) {
                    String msg = sc.nextLine();
                    String msgs[] = msg.split("@#");
                    //简单防黑。
                    if (msgs == null || msgs.length != 4) {
                        System.out.println("通讯异常:" + msg);
                        return;
                    }

                    if ("on".equals(msgs[0])) {//表示客户端的请求是：向别人发送信息
                        sendMsgToSb(msgs);

                    } else if ("exit".equals(msgs[0])) {//表示客户端发送的请求是:退出(下线)
                        area.append("\r\n" + msgs[3] + "下线了" + s);
                        dataModel.removeElement(msgs[3]);
                        userMap.remove(msgs[3]);

                        //通知其他所有在线的用户,***退出了
                        sendSbExitMsgToAll(msgs);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //命令关键字@#接收方@#消息内容@#发送方
    public void sendMsgToSb(String[] msgs) throws IOException {
        //可能是发给所有人,也可能是发给某一个人
        if ("全部".equals(msgs[1])) {
            //发给所有人(群聊)
            Iterator<String> it = userMap.keySet().iterator();
            while (it.hasNext()) {
                String userName = it.next();
                String msg = null;
                if (userName.equals(msgs[3])) {
                    msg = "msg@#" + "我" + "@#说:" + msgs[2];
                } else {
                    msg = "msg@#" + msgs[3] + "@#说:" + msgs[2];
                }
                Socket s = userMap.get(userName);
                //msg@#消息发送者@#消息内容
                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                pw.println(msg);
            }
        } else {
            //发送给某一个人
            String userName = msgs[1];
            Socket s = userMap.get(userName);
            //msg@#消息发送者@#消息内容
            String msg = "msg@#" + msgs[3] + "@#对你说:" + msgs[2];
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println(msg);

            //在发给自己
            Socket s2 = userMap.get(msgs[3]);
            PrintWriter pw2 = new PrintWriter(s2.getOutputStream(), true);
            String str2 = "msg@#" + "我" + "@#对 " + userName + "说:" + msgs[2];
            pw2.println(str2);
        }
    }

    //通知其他所有在线的用户,***退出了
    //1) msg @# server @# 用户[userName]退出了  (给客户端显示用的)
    //2) cmdRed@#server @# userName (给客户端维护在线用户列表用的)
    public void sendSbExitMsgToAll(String[] msgs) throws IOException {
        Iterator<String> it = userMap.keySet().iterator();
        while (it.hasNext()) {
            String userName = it.next();
            Socket s = userMap.get(userName);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            String msg = "msg@#server@#用户[" + msgs[3] + "]退出了";
            pw.println(msg);
            msg = "cmdRed@#server@#" + msgs[3];
            pw.println(msg);
        }
    }

    //表情处理


    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new ServerFrom();
    }
}

