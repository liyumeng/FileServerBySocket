package me.liyumeng.Server.ServerCmdHandlers;

import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class UnknownCmdHandler extends BaseServerCmdHandler {
    String m_cmd;
    Socket m_client;

    public UnknownCmdHandler(String cmd, Socket client) {
        super(cmd,client);
    }

    @Override
    public void Process() {
        System.out.println("未知类型命令：" + m_cmd);
    }
}
