// producer.php\nrequire_once __DIR__ . '/vendor/autoload.php';\nuse PhpAmqpLib\Connection\AMQPStreamConnection;\nuse PhpAmqpLib\Message\AMQPMessage;\n\n$connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');\n$channel = $connection->channel();\n\n$channel->queue_declare('task_queue', false, true, false, false);\n\n$data = json_encode(['email' => 'user@example.com']);\n$msg = new AMQPMessage($data, ['delivery_mode' => AMQPMessage::DELIVERY_MODE_PERSISTENT]);\n\n$channel->basic_publish($msg, '', 'task_queue');\n\necho " [x] Sent ", $data, "\n";\n\n$channel->close();\n$connection->close();