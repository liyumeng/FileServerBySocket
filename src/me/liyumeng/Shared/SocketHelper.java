package me.liyumeng.Shared;

import java.io.*;
import java.net.Socket;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 */
public class SocketHelper {
    public static void SendFile(String filename, Socket client) throws IOException {
        File file = new File(filename);
        DataOutputStream clientStream = new DataOutputStream(client.getOutputStream());
        FileInputStream fileStream = new FileInputStream(file);
        byte[] sendByte = new byte[1024];
        int length;
        while ((length = fileStream.read(sendByte, 0, sendByte.length)) > 0) {
            clientStream.write(sendByte, 0, length);
            clientStream.flush();
        }
        client.shutdownOutput();

    }

    public static void ReceiveFile(String filename, Socket client) throws IOException {
        DataInputStream clientStream = new DataInputStream(client.getInputStream());
        File file = new File(filename);
        FileOutputStream fileStream = new FileOutputStream(file);
        byte[] inputByte = new byte[1024];

        int length;
        while ((length = clientStream.read(inputByte, 0, inputByte.length)) > 0) {
            fileStream.write(inputByte, 0, length);
            fileStream.flush();
        }
        fileStream.close();
    }
}