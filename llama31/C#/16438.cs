// Receive data via HTTP handler\npublic async Task HandleRequestAsync(HttpRequest request)\n{\n    // Process incoming data\n    var data = await request.Content.ReadAsStringAsync();\n\n    // Produce message to Kafka topic\n    var producer = new Producer<string, string>(new ProducerConfig { BootstrapServers = "localhost:9092" });\n    await producer.ProduceAsync("my_topic", new Message<string, string> { Key = Guid.NewGuid().ToString(), Value = data });\n}\n\n// Consume messages from Kafka topic and process data\npublic async Task ProcessDataAsync()\n{\n    var consumer = new Consumer<string, string>(new ConsumerConfig { GroupId = "my_group", BootstrapServers = "localhost:9092" });\n    consumer.Subscribe(new[] { "my_topic" });\n\n    while (true)\n    {\n        var result = await consumer.ConsumeAsync();\n        var data = result.Message.Value;\n\n        // Process data\n        var processedData = Process(data);\n\n        // Save processed data to Cassandra\n        var cassandraCluster = Cluster.Builder().AddContactPoint("localhost").Build();\n        var session = cassandraCluster.Connect();\n        await session.ExecuteAsync(new SimpleStatement("INSERT INTO my_table (id, data) VALUES (uuid(), ?)", processedData));\n    }\n}