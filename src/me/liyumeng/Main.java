package me.liyumeng;

import me.liyumeng.Client.FileClient;
import me.liyumeng.Server.FileServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        FileServer server=new FileServer(10090);
        server.start();
        FileClient client=new FileClient("localhost",10090);

        while(true)
        {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            String cmd=reader.readLine();
            if(cmd.equals("quit")){break;}

            client.SendCommand(cmd);
        }

        System.out.print("Hello World.");

    }
}
