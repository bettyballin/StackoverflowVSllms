int backlog = 1024; // increase this value\nserver_socket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);\nlisten(server_socket, backlog);