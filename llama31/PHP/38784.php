use React\Socket\ConnectionPool;\n\n$loop = React\EventLoop\Factory::create();\n\n$pool = new ConnectionPool($loop, 'tcp://example.com:8080', 10); // 10 connections in the pool\n\n$pool->connect(function ($connection) {\n    // Use the connection\n    $connection->write('Hello!');\n    // ...\n});