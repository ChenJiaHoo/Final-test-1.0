package Client.JFrame.server;

import Client.JFrame.ClientUserLoginFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
    Socket socket;

    public ChatSocket(Socket s) {
          this.socket = s;
    }

    //发送数据
    public void out(String out) {
        try {
            socket.getOutputStream().write(out.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务器读取内容发送给集合内的客户
    public void run() {
        try {
            //接收数据
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            String line = null;
            //发送读到的数据
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Client.JFrame.server.ChatManager.getChatManager().publish(this, line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
