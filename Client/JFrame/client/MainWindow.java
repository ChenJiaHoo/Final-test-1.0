package Client.JFrame.client;

//import Server.ChatManager;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame implements KeyListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea txt;
    private JTextField txtSend;
    private JButton btnSend;

    /**
     * Create the frame.
     * @throws UnknownHostException
     */
    public MainWindow() throws UnknownHostException {
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("群聊天室");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        txt = new JTextArea();
        txt.setText(InetAddress.getLocalHost().getHostAddress()+"加入群聊了！"+"\n");


        /**
         * 一打开就连接上
         */
        InetAddress addr=InetAddress.getLocalHost();
        String ip=addr.getHostAddress().toString();
        Client.JFrame.client.ChatManager.getChatManager().connect(ip);

        txtSend = new JTextField();
        txtSend.setText("hello");
        txtSend.setColumns(10);

        btnSend = new JButton("send");
        btnSend.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Client.JFrame.client.ChatManager.getChatManager().send(txtSend.getText());
                appendText("我:"+txtSend.getText());
                txtSend.setText("");
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(txtSend, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()

                                                .addPreferredGap(ComponentPlacement.RELATED))

                                        .addComponent(txt, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE))


                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(txt, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(btnSend)
                                        .addComponent(txtSend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        contentPane.setLayout(gl_contentPane);
    }

    /**
     *获取当前系统的时间
     * @return
     */
    public String getDate(){
        Calendar now=Calendar.getInstance();
        return new SimpleDateFormat("HH:mm:ss").format(now.getTime());
    }

    /*客户端发送的内容添加到中间的txt控件中*/
    public void appendText(String in) {
        txt.append("             "+getDate()+"\n"+in+"\n");
//        txt.append("\n\n" + in+"  "+getDate());
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar()==KeyEvent.VK_ENTER){
            Client.JFrame.client.ChatManager.getChatManager().send(txtSend.getText());
            appendText("我:"+txtSend.getText());
            txtSend.setText("");
        }
    }
}