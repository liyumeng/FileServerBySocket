package me.liyumeng;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class MessageHandler implements Runnable {

    private Socket m_client=null;

    public MessageHandler(Socket client) {
        m_client=client;
    }
    @Override
    public void run() {
        try {
            DataInputStream stream = new DataInputStream(m_client.getInputStream());
            String cmd=stream.readUTF();
            System.out.println("服务器收到消息：" + cmd);




            stream.close();
            m_client.close();
            m_client=null;
            System.out.println("请求处理完毕，关闭Socket连接。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
