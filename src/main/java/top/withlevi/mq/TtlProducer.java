package top.withlevi.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

// 定义一个名为SingleProducer的公开类，用于实现消息发送功能
public class TtlProducer {
    // 定义一个静态常量字符串QUEUE_NAME，它的值为"hello"，表示我们要向名为"hello"的队列发送消息
    private final static String QUEUE_NAME = "ttl_queue";

    // 定义程序的入口点：一个公开的静态main方法，它抛出Exception异常
    public static void main(String[] argv) throws Exception {
        // 创建一个ConnectionFactory对象，这个对象可以用于创建到RabbitMQ服务器的连接
        ConnectionFactory factory = new ConnectionFactory();
        // 设置ConnectionFactory的主机名为"localhost"，这表示我们将连接到本地运行的RabbitMQ服务器
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin");
        try (Connection connection = factory.newConnection();
             // 通过已建立的连接创建一个新的频道
             Channel channel = connection.createChannel()) {
            // 创建要发送的消息，这里我们将要发送的消息内容设置为"Hello World!"
            String message = "Hello World!";
            // 给消息指定过期时间
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .expiration("5000")
                            .build();
            // 使用channel.basicPublish方法将消息发布到指定的队列中。这里我们指定的队列名为"ttl_queue"
            channel.basicPublish("",QUEUE_NAME,properties, message.getBytes(StandardCharsets.UTF_8));
            // 使用channel.basicPublish方法将消息发布到指定的队列中。这里我们指定的队列名为"ttl_queue"
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}