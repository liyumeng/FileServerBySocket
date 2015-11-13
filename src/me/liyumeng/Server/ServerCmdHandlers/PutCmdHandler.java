package me.liyumeng.Server.ServerCmdHandlers;

import me.liyumeng.Shared.SocketHelper;

import java.io.*;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class PutCmdHandler implements IServerCmdHandler {
    String m_cmd;
    Socket m_client;

    public PutCmdHandler(String cmd, Socket client) {
        m_cmd = cmd;
        m_client = client;
    }

    @Override
    public void Process() {
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(m_client.getOutputStream());
            outputStream.writeUTF("ready:" + m_cmd);
            String[] items=m_cmd.split(" ");
            SocketHelper.ReceiveFile(items[2],m_client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
