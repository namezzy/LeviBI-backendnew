package top.withlevi.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

public class DirectProducer {
    // 定义交换机名称
    private static final String EXCHANGE_NAME = "direct-exchange";

    public static void main(String[] argv) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置连接工厂的主机地址为本地主机
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 建立连接并创建通道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 使用通道声明交换机，类型为direct
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // 创建一个Scanner对象用于读取用户输入
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                // 读取用户输入的一行内容, 并以空格分割
                String userInput = scanner.nextLine();
                String[] strings = userInput.split(" ");
                // 如果输入的内容不符合要求， 继续读取下一行
                if (strings.length < 1) {
                    continue;
                }

                // 获取消息内容和路由键
                String message = strings[0];
                String routingKey = strings[1];

                // 发布消息到交换机
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + message + " with routing" + routingKey + "'");

            }

        }
    }
    //..
}