package me.liyumeng;

import me.liyumeng.ServerCommands.GetCommand;
import me.liyumeng.ServerCommands.IServerCommand;
import me.liyumeng.ServerCommands.PutCommand;
import me.liyumeng.ServerCommands.UnknownCommand;

/**
 * Created by Yumeng Li on 2015/11/13 0013.
 */
public class ServerCommandFactory {
    public static IServerCommand CreateHandler(String cmd)
    {
        int index=cmd.indexOf(' ');
        String key=cmd.substring(0,cmd.indexOf(' ')).toLowerCase();
        switch (key)
        {
            case "get":return new GetCommand();
            case "put":return new PutCommand();
            default:return new UnknownCommand();
        }
    }
}
