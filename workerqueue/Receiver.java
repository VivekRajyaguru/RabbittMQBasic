package workerqueue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receiver {
	
	private static final String queueName = "demo";
	
	
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(queueName, false,false, false, null);
		
		Consumer consumer = new DefaultConsumer(channel) {
		@Override
		 public void handleDelivery(String consumerTag, Envelope envelope,
                 AMQP.BasicProperties properties, byte[] body)  {
				try{
					String message = new String(body, "UTF-8");
					System.out.println("start "+ message);
					working(message);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					System.out.println("end");
				}
			}
		};
		boolean ackn = true;
		channel.basicConsume(queueName, ackn, consumer);
	}
	
	private static void working(String message) throws Exception{
		Thread.sleep(100);
	}
}
