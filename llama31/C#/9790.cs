using Apache.NMS;\nusing Apache.NMS.ActiveMQ;\n\n// Create a connection and session\nIConnection connection = new ConnectionFactory("tcp://localhost:61616").CreateConnection();\nISession session = connection.CreateSession();\n\n// Create a consumer\nIMessageConsumer consumer = session.CreateConsumer(new ActiveMQQueue("your_queue_name"));\n\n// Start the connection\nconnection.Start();\n\n// Process messages in a loop\nwhile (true)\n{\n    // Get multiple messages at once\n    IMessage[] messages = consumer.ReceiveBatch(100, TimeSpan.FromSeconds(1));\n\n    // Process each message\n    foreach (IMessage message in messages)\n    {\n        // Process the message here\n    }\n}