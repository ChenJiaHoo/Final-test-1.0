package Client.JFrame.server;

import Client.JFrame.ClientFrom;
import com.mysql.fabric.Server;

import java.util.Vector;

public class ChatManager {
    //饿汉式单例化处理
    private ChatManager(){}
    private static final ChatManager CM=new ChatManager();
    public static ChatManager getChatManager(){
        return CM;
    }

    //向量容器
    Vector<Client.JFrame.server.ChatSocket> vector=new Vector<Client.JFrame.server.ChatSocket>();

    //添加chatsocket实例到容器中
    public void add(Client.JFrame.server.ChatSocket cs){
        vector.add(cs);
    }

    //发送信息给添加到容器中的客户端,除了发送给自己
    public void publish(Client.JFrame.server.ChatSocket cs, String msg){
        for(int i=0;i<vector.size();i++){
            Client.JFrame.server.ChatSocket csTemp=vector.get(i);
            if (!cs.equals(csTemp)){
                csTemp.out(msg+"\n");
            }
        }
    }
}
