package me.liyumeng.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Yumeng Li on 2015/11/14 0014.
 */
public class Run {
    public static void main(String[] args) throws Exception {

        while(true)
        {
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

            System.out.println("[客户端]请输入命令：");
            String cmd=reader.readLine();
            if(cmd.equals("quit")){break;}
            FileClient.Send(cmd);
        }
        System.out.println("[客户端]已退出");

    }
}
