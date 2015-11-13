package me.liyumeng.Server.ServerCmdHandlers;

import me.liyumeng.Shared.SocketHelper;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class GetCmdHandler implements IServerCmdHandler {
    String m_cmd;
    Socket m_client;

    public GetCmdHandler(String cmd, Socket client) {
        m_cmd = cmd;
        m_client = client;
    }

    /**
     * 处理 get remote_file local_file
     * 返回服务器上的文件
     */
    @Override
    public void Process() {
        String[] items = m_cmd.split(" ");
        if (items.length != 3) {
            System.out.println("get参数错误，应为:get remote_file local_file");
            return;
        }
        System.out.println("读取文件：" + items[1]);
        try {
            SocketHelper.SendFile(items[1],m_client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
