package me.liyumeng.Client.ClientCmdHandlers;

import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 */
public class BaseClientCmdHandler implements IClientCmdHandler {
    String m_cmd;
    Socket m_client;

    public BaseClientCmdHandler(String cmd, Socket client) {
        m_cmd = cmd;
        m_client = client;
    }

    @Override
    public void Process() {
    }
}
