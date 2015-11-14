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
    private FileServer m_server = null;

    public ServerThread(Socket client, FileServer server) {
        m_client = client;
        m_server = server;
    }

    @Override
    public void run() {
        try {
            m_server.AddCount();    //增加正在连接的客户端数量
            DataInputStream stream = new DataInputStream(m_client.getInputStream());
            String cmd = stream.readUTF();
            System.out.println(String.format("[服务器]已接收到请求：%s，目前%d个客户端正在连接。",
                    cmd, m_server.ClientCount));

            IServerCmdHandler handler = ServerCmdHandlerFactory.CreateHandler(cmd, m_client);

            handler.Process();  //处理请求命令

            stream.close();
            this.Close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            m_server.MinusCount();  //客户端退出
            System.out.println(String.format("[服务器]请求处理完毕，关闭Socket连接。剩余：%d个客户端连接",
                    m_server.ClientCount));
        }
    }

    public void Close() throws IOException {
        if (m_client != null) {
            m_client.close();
            m_client = null;
        }
    }


}
