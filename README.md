# RabbittMQBasic
This is just a sample Program for RabbitMQ sender and Receiver


Prerequisites for this project
1)Install Erlang in your machine
https://www.rabbitmq.com/which-erlang.html
2)Install RabbitMQ server 
https://www.rabbitmq.com/install-windows.html
3)Third-Party jars are required. it already include in project files.it also required log4j for logging.
if you are using maven based project than use groupId com.rabbitmq and artifactId amqp-client



------------------------------------------------------------------------------------------------
RabbitMQ is a message broker: it accepts and forwards messages.
Components of rabbitmq
1)producer -- it is nothing but java program that send/produces/publish message.
2)queue -- it is kind of tunnel/linkage from your your program and rabbitmq server.
it's essentially a large message buffer.
Many producers can send messages that go to one queue, and many consumers can try to receive data from one queue.
3)Consumer -- it is nothing but java program that receive message that publish by producer.

Points to take care.
->queue name for consumer must be same as producer's queue name to recieve message. 
->message will send and receive in byte array.
->rabbitmq needs 200MB free disk space for its buffer otherwise it wont accept and send message.
->for manual configuration and tunnning please use http://www.rabbitmq.com/configure.html#config-items  


if you have any query please feel free to reach out me on vivekrajyaguru1993@gmail.com or +919408753791.

I am always open for help in open source stuff Java, Angular 2/4, Python, JavaScript, Jquery, Spring, Hibernate.

Thanks.
