package Client.JFrame.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatManager {
    private ChatManager(){}
    private static final ChatManager instance=new ChatManager();
    public static ChatManager getChatManager(){
        return instance;
    }
    MainWindow window;//为了能在界面上显示服务器发来的信息，就需要传一个MainWindow的引用进来
    Socket socket;
    private String IP;
    BufferedReader bReader;
    PrintWriter pWriter;
    public void setWindow(MainWindow window) {
        this.window = window;

    }
    /**
     * 获取本地电脑的ip
     * @param ip
     */
    public void connect(String ip) {
        this.IP = ip;
        new Thread(){

            @Override
            public void run() {
                //实现网络方法
                try {
                    socket = new Socket(IP, 22345);
                    //输出流
                    pWriter = new PrintWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()));
                    //输入流
                    bReader = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

                    String line = null;

                    //接收数据 暂时先用IP做头
                    while ((line = bReader.readLine())!=null) {
                        window.appendText(IP+":"+"  "+line);
                    }

                    //读完数据之后要关闭
                    pWriter.close();
                    bReader.close();
                    pWriter = null;
                    bReader = null;

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }



    public void send(String sendMsg){
        if (pWriter!=null) {
            pWriter.write(sendMsg+"\n");
            pWriter.flush();
        } else {
            window.appendText("当前链接已经中断...");
        }
    }
}