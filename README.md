# FileServerBySocket
A simple file server in Java using socket

###任务
使用socket编程实现一个简单的文件服务器。客户端程序实现put功能（将一个文件从本地传到文件服务器）和get功能（从文件服务器取一远程文件存入本地文件）。客户端和文件服务器不在同一台机器上。

put [-h hostname][-p portname] local_filename remote_filename

get [-h hostname][-p portname] remote_filename local_filename

程序使用java语言编写。

文件`/src/me/liyumeng/Server/Run.java`为Server端运行的主函数

文件`/src/me/liyumeng/Client/Run.java`为Client端运行的主函数

在命令行下输入`java me.liyumeng.Server.Run`也可直接运行

在客户端和服务端均采用简单工厂模式处理请求命令

ServerCmdHandlers包下的类负责处理各个命令关键字，每个关键字对应一个类，所有处理关键字的类都实现了IServerCmdHandler接口，接口中定义了Process()的处理方法，本任务中关键字只有两个且较为简单，所以均继承自BaseServerCmdHandler。由ServerCmdHandlerFactory工厂类负责根据命令语句，返回对应Handler的实例。
