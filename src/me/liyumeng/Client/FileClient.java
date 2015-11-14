package me.liyumeng.Client;

import me.liyumeng.Client.ClientCmdHandlers.ClientCmdHandlerFactory;
import me.liyumeng.Client.ClientCmdHandlers.IClientCmdHandler;

import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 * 客户端连接类
 */
public class FileClient {
    private String m_ip;
    private int m_port;

    /*传入服务端的IP和端口，进行实例化*/
    public FileClient(String ip, int port) {
        m_ip = ip;
        m_port = port;
    }

    /*客户端向服务器发送指令*/
    public void SendCommand(String cmd) throws IOException {
        Socket client = new Socket(m_ip, m_port);

        /*根据指令的不同，由工厂类决定实例化出不同的CmdHandler处理对象*/
        IClientCmdHandler handler = ClientCmdHandlerFactory.CreateHandler(cmd, client);
        handler.Process();

        client.close();
    }

    /*使用正则表达式匹配出-h 和-p 参数*/
    private static Pattern m_hostnamePattern = Pattern.compile("-h (?<HOSTNAME>[^ ]+) ");
    private static Pattern m_portPattern = Pattern.compile("-p (?<PORT>[\\d]+)[ ]*");

    /**
     * 解析输入的指令，创建客户端的Socket连接，并向服务端发送指令
     * @param cmd
     * @throws Exception
     */
    public static void Send(String cmd) throws Exception {
        Matcher hostnameMather = m_hostnamePattern.matcher(cmd);

        Matcher portPatternMather = m_portPattern.matcher(cmd);
        if (hostnameMather.find() && portPatternMather.find()) {
            String hostname = hostnameMather.group(1);
            int port = Integer.parseInt(portPatternMather.group(1));
            FileClient client = new FileClient(hostname, port);

            cmd = hostnameMather.replaceFirst("");
            portPatternMather = m_portPattern.matcher(cmd);
            cmd = portPatternMather.replaceFirst("");

            client.SendCommand(cmd);
        } else {
            System.out.println("缺少-h hostname或-p port参数");
        }
    }
}
