$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);\nsocket_bind($socket, 'localhost', 8080);\nsocket_listen($socket);\n\n$client_socket = socket_accept($socket);\nsocket_write($client_socket, "Hello, client!");\nsocket_close($client_socket);\n\nsocket_close($socket);