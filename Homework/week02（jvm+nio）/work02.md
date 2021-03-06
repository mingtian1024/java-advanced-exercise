### **Week02 作业题目：**

**1.（选做）**使用 GCLogAnalysis.java 自己演练一遍串行 / 并行 /CMS/G1 的案例。

~~~xml
// 打印GC日志
-XX:+PrintGCDetails
// 打印GC日志时间戳
-XX:+PrintGCDateStamps
// 将GC日志存至指定log文件
-Xloggc:gc.demo.log
// 使用串行GC
-XX:+UseSerialGC
// 使用并行GC
-XX:+UseParallelGC
// 使用CMS
-XX:+UseConcMarkSweepGC
~~~

**2.（选做）**使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

~~~xml
wrk -c 40 -d30s http://localhost:8081

wrk命令行参数
-t 线程数量
-c 连接数
-d 延迟时间
–timeout 超时时间
~~~



**3.（选做）**如果自己本地有可以运行的项目，可以按照 2 的方式进行演练。

**4.（必做）**根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。

![](GC.png)

**5.（选做）**运行课上的例子，以及 Netty 的例子，分析相关现象。
**6.（必做）**写一段代码，使用 HttpClient 或 OkHttp 访问 [ http://localhost:8801 ](http://localhost:8801/)，代码提交到 GitHub

[TestOkHttp.java](https://github.com/SkyMing1024/java-advanced-exercise/blob/main/java-advanced-project/src/main/java/com/sky/week02nio/TestOkHttp.java)

~~~javascript
// 服务端
public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        while (true){
            Socket socket = serverSocket.accept();
            service(socket);
        }

    }
    public static void service(Socket socket){
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("HTTP/1.0 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "Hello,nio1";
            System.out.println("Hello,nio1");
            printWriter.println("Content-Length："+body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 客户端
public class TestOkHttp {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "http://localhost:8081";
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String text = response.body().string();
        System.out.println(url + ": " + text);
        client = null;
    }
}
~~~

