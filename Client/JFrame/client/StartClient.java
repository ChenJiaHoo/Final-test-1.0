package Client.JFrame.client;

//import Server.ChatManager;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.*;

public class StartClient {
     public static void main(String[] args){
         EventQueue.invokeLater(new Runnable() {
             @Override
             public void run() {
                 try {
                     MainWindow frame = new MainWindow();
                     frame.setVisible(true);
                     Client.JFrame.client.ChatManager.getChatManager().setWindow(frame);
                 }catch (Exception e){
                     e.printStackTrace();
                 }
                 }
         });
         try {
           BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

       } catch (Exception e) {// TODO Auto-generated catch block
           e.printStackTrace();
         }
     }
}
