using RabbitMQ.Client;\nusing RabbitMQ.Client.Events;\n\n// Create a connection to the RabbitMQ server\nvar connection = ConnectionFactory.CreateConnection("amqp://guest:guest@localhost:5672");\nvar channel = connection.CreateModel();\n\n// Declare an exchange and queue for the emergency broadcast\nchannel.ExchangeDeclare("emergency_broadcast", ExchangeType.Fanout);\nchannel.QueueDeclare("emergency_broadcast_queue", true, false, false, null);\n\n// Bind the queue to the exchange\nchannel.QueueBind("emergency_broadcast_queue", "emergency_broadcast", "", "", true);\n\n// Create a consumer to listen for incoming messages\nvar consumer = new EventingBasicConsumer(channel);\nconsumer.Received += (sender, args) =>\n{\n    var message = Encoding.UTF8.GetString(args.Body);\n    // Display the message to the user\n    Console.WriteLine(message);\n};\n\n// Start consuming messages\nchannel.BasicConsume("emergency_broadcast_queue", true, consumer);