package me.liyumeng.Server.ServerCmdHandlers;


import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 * 服务端执行命令的工厂方法
 * 根据传入的命令提示符，决定使用哪个命令处理类进行处理
 */
public class ServerCmdHandlerFactory {

    public static IServerCmdHandler CreateHandler(String cmd,Socket client) {
        if (cmd.length() == 0)
            return new UnknownCmdHandler(cmd,client);

        int index = cmd.indexOf(' ');
        String key = index > 0 ? cmd.substring(0, index) : cmd;
        //判断命令开头的标识是什么
        switch (key.toLowerCase()) {
            case "get":
                return new GetCmdHandler(cmd,client);
            case "put":
                return new PutCmdHandler(cmd,client);
            default:
                return new UnknownCmdHandler(cmd,client); //未知标识返回Unknown处理器
        }
    }
}
