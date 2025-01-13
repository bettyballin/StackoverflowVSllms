// Local app\nusing RabbitMQ.Client;\n\n// Send product data to web app\nvar product = new Product { Id = 1, Name = "Example Product" };\nvar body = Encoding.UTF8.GetBytes(JsonConvert.SerializeObject(product));\nvar properties = new BasicProperties\n{\n    Persistence = true,\n    Type = "text/json"\n};\nvar exchange = "products";\nvar routingKey = "add_product";\nvar connection = ConnectionFactory.CreateConnection();\nvar channel = connection.CreateModel();\nchannel.BasicPublish(exchange, routingKey, body, properties);\n\n// Web app\nusing RabbitMQ.Client;\n\n// Receive product data from local app\nvar connection = ConnectionFactory.CreateConnection();\nvar channel = connection.CreateModel();\nvar queue = "products";\nvar consumer = new QueueingBasicConsumer(channel);\nchannel.BasicConsume(queue, true, consumer);\nwhile (true)\n{\n    var message = consumer.Queue.Dequeue();\n    var product = JsonConvert.DeserializeObject<Product>(message.Body);\n    // Add product to web app DB\n}