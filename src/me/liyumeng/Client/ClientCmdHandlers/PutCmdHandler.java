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

    @Override
    public void Process() {
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(m_client.getOutputStream());

            outputStream.writeUTF(m_cmd);

            DataInputStream stream = new DataInputStream(m_client.getInputStream());

            String callback = stream.readUTF();
            if (callback.equals("ready:" + m_cmd)) {
                String[] items = m_cmd.split(" ");
                SocketHelper.SendFile(items[1], m_client);
                System.out.println(String.format("文件:%s 已上传到服务器路径：%s。",items[1],items[2]));
            }

            m_client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
