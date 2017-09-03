package com;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {
	
	private final static String queueName = "demo";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		
		Connection connection = factory.newConnection();
		
		Channel channel = connection.createChannel();
		channel.queueDeclare(queueName, false, false, false, null);
		String message = "This is a test Messsage.";
		channel.basicPublish("", queueName, null, message.getBytes());
		channel.close();
		connection.close();
	}
	
}
