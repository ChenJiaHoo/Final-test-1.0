package Client.JFrame.server;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {
    public void run(){
        try {
            ServerSocket serversocket=new  ServerSocket(22345);
            while(true){
                Socket socket=serversocket.accept();
                System.out.println(socket.getInetAddress()+"加入群聊了！");
                //每当有新的地址连上就有新的线程分配给这个用户
                Client.JFrame.server.ChatSocket chatsocket=new  Client.JFrame.server.ChatSocket(socket);
                chatsocket.start();
                //加入线程管理类中
                Client.JFrame.server.ChatManager.getChatManager().add(chatsocket);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

