$host = "127.0.0.1";\n$port = 1234;\n\n$s = socket_create(AF_INET, SOCK_STREAM, 0);\nsocket_connect($s, $host, $port);\n\nsocket_write($s, "test", strlen("test"));\nsocket_shutdown($s, 1); // shut down for writing\n\n$response = socket_read($s, 3, PHP_NORMAL_READ);\necho $response;\n\nsocket_close($s);