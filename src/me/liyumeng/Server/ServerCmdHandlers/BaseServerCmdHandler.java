package me.liyumeng.Server.ServerCmdHandlers;

import java.net.Socket;

/**
 * Created by Tooony on 2015/11/14 0014.
 */
public class BaseServerCmdHandler implements IServerCmdHandler {
    String m_cmd;
    Socket m_client;

    public BaseServerCmdHandler(String cmd, Socket client) {
        m_cmd = cmd;
        m_client = client;
    }
    @Override
    public void Process() {

    }
}
