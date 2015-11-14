package me.liyumeng.Client.ClientCmdHandlers;

import me.liyumeng.Shared.SocketHelper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 */
public class PutCmdHandler extends BaseClientCmdHandler {
    public PutCmdHandler(String cmd, Socket client) {
        super(cmd, client);
    }

    /**
     * 在put指令中，首先客户端请求上传文件，
     * 服务端接收到指令后返回ready信号，
     * 然后客户端才开始上传
     */
    @Override
    public void Process() {
        DataOutputStream outputStream;
        try {
            outputStream = new DataOutputStream(m_client.getOutputStream());

            outputStream.writeUTF(m_cmd);

            DataInputStream stream = new DataInputStream(m_client.getInputStream());

            //客户端等待服务端的ready信号
            String callback = stream.readUTF();
            //如果是ready信号
            if (callback.equals("ready:" + m_cmd)) {
                String[] items = m_cmd.split(" ");
                SocketHelper.SendFile(items[1], m_client);  //客户端开始发送文件
                System.out.println(String.format("[客户端]文件:%s 已上传到服务器路径：%s。",items[1],items[2]));
            }

            m_client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
