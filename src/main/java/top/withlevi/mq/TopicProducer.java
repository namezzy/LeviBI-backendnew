package top.withlevi.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

public class TopicProducer {

    // 定义交换机名称为: "topic_exchange"
    private static final String EXCHANGE_NAME = "topic_exchange";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        // 创建连接工厂
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 创建连接和通道，并确保资源自动关闭
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // 声明使用主体交换机 并指定交换机名称和类型
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            // 创建一个扫描器, 从控制台读取用户输入
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                // 读取用户输入的一行文本
                String userInput = scanner.nextLine();
                // 使用空格分割用户输入的文本
                String[] strings = userInput.split(" ");
                // 如果分隔后的文本长度小于2 则跳过当前循环
                if (strings.length < 1) {
                    continue;
                }
                // 获取用户输入的消息
                String message = strings[0];
                // 获取用户输入的路由键
                String routingKey = strings[1];

                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
                System.out.println(" [x] Sent '" + message + "'with routing: '" + routingKey + "'");

            }


        }
    }
}