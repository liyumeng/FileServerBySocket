package me.liyumeng;

import me.liyumeng.Client.FileClient;
import me.liyumeng.Server.FileServer;
import java.io.IOException;

public class Main {

    /**
     * 目前支持的两种语法
     * put [-h hostname][-p portname] local_filename remote_filename
     * get [-h hostname][-p portname] remote_filename local_filename
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {
        FileServer server = new FileServer(10090);
        server.start();
        FileClient.Send("put -h localhost -p 10090 f:\\20.cmd f:\\30.cmd");
        FileClient.Send("get -h localhost -p 10090 f:\\20.cmd f:\\30.cmd");

    }
}
