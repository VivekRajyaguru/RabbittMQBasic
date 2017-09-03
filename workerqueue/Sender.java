package workerqueue;

import java.util.Scanner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
	
	private final static String queueName = "demo";

	private static String getMessage(String message) {
		return message;
	}
	
	public static void main(String[] args)  {
		try {
			Scanner sc = new Scanner(System.in);
			String scan = sc.nextLine();
			sc.close();
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			
			Connection connection = factory.newConnection();
			
			Channel channel = connection.createChannel();
			channel.queueDeclare(queueName, false, false, false, null);
			String message = getMessage(scan);
			channel.basicPublish("", queueName, null, message.getBytes());
			channel.close();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
