package me.liyumeng.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class FileServer extends Thread {
    private ServerSocket m_ss = null;
    private final int m_port;
    public int ClientCount = 0;
    public Object CountObject=new Object();

    public FileServer(int port) {
        m_port = port;
    }

    public void run() {
        try {
            m_ss = new ServerSocket(m_port);
            System.out.println("[服务器]正在监听" + m_port + "端口...");
            while (true) {
                Socket client = m_ss.accept();    //服务器接受请求
                Thread handlerThread = new Thread(new ServerThread(client, this));  //开启新线程处理请求信息
                handlerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AddCount(){
        synchronized (CountObject)
        {
            ClientCount++;
        }
    }

    public void MinusCount(){
        synchronized (CountObject)
        {
            ClientCount--;
        }
    }
}
