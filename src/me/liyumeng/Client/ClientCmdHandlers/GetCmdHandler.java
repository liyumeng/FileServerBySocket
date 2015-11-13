package me.liyumeng.Client.ClientCmdHandlers;

import me.liyumeng.Shared.SocketHelper;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 */
public class GetCmdHandler extends BaseClientCmdHandler {

    public GetCmdHandler(String cmd, Socket client) {
        super(cmd, client);
    }

    @Override
    public void Process() {
        DataOutputStream outputStream;
        try {
            outputStream = new DataOutputStream(m_client.getOutputStream());
            outputStream.writeUTF(m_cmd);

            String[] items = m_cmd.split(" ");
            SocketHelper.ReceiveFile(items[2], m_client);
            outputStream.close();
            m_client.close();
            System.out.println("文件已保存到：" + items[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
