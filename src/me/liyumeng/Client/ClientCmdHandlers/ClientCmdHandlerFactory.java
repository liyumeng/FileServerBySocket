package me.liyumeng.Client.ClientCmdHandlers;

import me.liyumeng.Server.ServerCmdHandlers.*;
import me.liyumeng.Server.ServerCmdHandlers.PutCmdHandler;
import me.liyumeng.Server.ServerCmdHandlers.UnknownCmdHandler;

import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 * 客户端命令处理的工厂类
 */
public class ClientCmdHandlerFactory {

    public static IClientCmdHandler CreateHandler(String cmd, Socket client) {
        if (cmd.length() == 0)
            return new me.liyumeng.Client.ClientCmdHandlers.UnknownCmdHandler(cmd,client);

        int index = cmd.indexOf(' ');
        String key = index > 0 ? cmd.substring(0, index) : cmd;
        //判断命令开头的标识是什么
        switch (key.toLowerCase()) {
            case "get":
                return new me.liyumeng.Client.ClientCmdHandlers.GetCmdHandler(cmd,client);
            case "put":
                return new me.liyumeng.Client.ClientCmdHandlers.PutCmdHandler(cmd,client);
            default:
                return new me.liyumeng.Client.ClientCmdHandlers.UnknownCmdHandler(cmd,client); //未知标识返回Unknown处理器
        }
    }
}
