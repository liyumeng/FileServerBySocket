package me.liyumeng.Client.ClientCmdHandlers;

import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 */
public class UnknownCmdHandler extends BaseClientCmdHandler {

    public UnknownCmdHandler(String cmd, Socket client) {
        super(cmd, client);
    }

    @Override
    public void Process() {
        System.out.println("未知类型命令：" + m_cmd);
    }
}
