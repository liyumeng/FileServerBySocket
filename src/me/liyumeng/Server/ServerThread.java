package me.liyumeng.Server;

import me.liyumeng.Server.ServerCmdHandlers.IServerCmdHandler;
import me.liyumeng.Server.ServerCmdHandlers.ServerCmdHandlerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class ServerThread implements Runnable {

    private Socket m_client = null;

    public ServerThread(Socket client) {
        m_client = client;
    }

    @Override
    public void run() {
        try {
            DataInputStream stream = new DataInputStream(m_client.getInputStream());
            String cmd = stream.readUTF();
            System.out.println("服务器收到消息：" + cmd);

            IServerCmdHandler handler = ServerCmdHandlerFactory.CreateHandler(cmd, m_client);

            handler.Process();  //处理请求命令

            stream.close();
            this.Close();
            System.out.println("请求处理完毕，关闭Socket连接。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Close() throws IOException {
        if (m_client != null) {
            m_client.close();
            m_client = null;
        }
    }


}
