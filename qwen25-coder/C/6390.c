// server.c\n#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <unistd.h>\n#include <arpa/inet.h>\n\nint main() {\n    int server_fd, new_socket;\n    struct sockaddr_in address;\n    int addrlen = sizeof(address);\n    \n    // Creating socket file descriptor\n    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) {\n        perror("socket failed");\n        exit(EXIT_FAILURE);\n    }\n    \n    address.sin_family = AF_INET;\n    address.sin_addr.s_addr = INADDR_ANY;\n    address.sin_port = htons(8080);\n    \n    // Binding the socket to the port\n    if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {\n        perror("bind failed");\n        close(server_fd);\n        exit(EXIT_FAILURE);\n    }\n    \n    // Listening for connections\n    if (listen(server_fd, 3) < 0) {\n        perror("listen");\n        close(server_fd);\n        exit(EXIT_FAILURE);\n    }\n    \n    printf("Listening on port 8080...\n");\n    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, \n                             (socklen_t*)&addrlen))<0) {\n        perror("accept");\n        close(server_fd);\n        close(new_socket);\n        exit(EXIT_FAILURE);\n    }\n    \n    printf("Connection accepted\n");\n    \n    char buffer[1024] = {0};\n    read(new_socket, buffer, 1024);\n    printf("Received: %s\n",buffer );\n    send(new_socket , "Hello from server" , 17 , 0 );\n    printf("Hello message sent\n");\n    \n    close(new_socket);\n    close(server_fd);\n    return 0;\n}\n\n// client.c\n#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <string.h>\n#include <arpa/inet.h>\n\nint main() {\n    struct sockaddr_in serv_addr;\n    int sock = 0;\n    \n    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0) {\n        printf("\n Socket creation error \n");\n        return -1;\n    }\n  \n    serv_addr.sin_family = AF_INET;\n    serv_addr.sin_port = htons(8080);\n      \n    // Convert IPv4 and IPv6 addresses from text to binary form\n    if(inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr)<=0) {\n        printf("\nInvalid address/ Address not supported \n");\n        return -1;\n    }\n  \n    if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {\n        printf("\nConnection Failed \n");\n        return -1;\n    }\n    \n    send(sock , "Hello from client" , 17 , 0 );\n    printf("Hello message sent\n");\n    char buffer[1024] = {0};\n    read( sock , buffer, 1024);\n    printf("Received: %s\n",buffer); \n    close(sock);\n    return 0;\n}