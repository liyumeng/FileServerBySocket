package me.liyumeng.Server;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 */
public class Run {
    public static void main(String[] args) throws Exception {
        FileServer server=new FileServer(10090);
        server.run();
    }
}
