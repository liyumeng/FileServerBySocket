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
