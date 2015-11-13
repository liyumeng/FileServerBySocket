package me.liyumeng;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class FileClient {
    private String m_ip;
    private int m_port;
    public FileClient(String ip,int port){
        m_ip=ip;
        m_port=port;
    }

    public void SendCommand(String cmd) throws IOException {
        Socket client=new Socket(m_ip,m_port);
        DataOutputStream outputStream=new DataOutputStream(client.getOutputStream());
        outputStream.writeUTF(cmd);
        outputStream.close();
        client.close();
    }
}
