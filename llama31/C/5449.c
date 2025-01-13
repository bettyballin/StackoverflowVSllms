#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <sys/socket.h>\n#include <netinet/in.h>\n#include <arpa/inet.h>\n\nint main() {\n    int sockfd, connfd;\n    struct sockaddr_in servaddr, cliaddr;\n    socklen_t clilen = sizeof(cliaddr);\n\n    // Create socket and set up server address\n    sockfd = socket(AF_INET, SOCK_STREAM, 0);\n    servaddr.sin_family = AF_INET;\n    servaddr.sin_port = htons(8080);\n    inet_pton(AF_INET, "127.0.0.1", &servaddr.sin_addr);\n\n    // Bind and listen\n    bind(sockfd, (struct sockaddr *)&servaddr, sizeof(servaddr));\n    listen(sockfd, 5); // Create a listen queue with a backlog of 5\n\n    // Simulate a faulty client connection\n    // ...\n\n    // Another client connects and establishes a connection\n    // ...\n\n    // Call accept() to retrieve the established connection\n    connfd = accept(sockfd, (struct sockaddr *)&cliaddr, &clilen);\n    if (connfd < 0) {\n        perror("accept");\n        exit(EXIT_FAILURE);\n    }\n\n    // Handle the established connection...\n    printf("Established connection from client IP address %s and port %d\n",\n           inet_ntoa(cliaddr.sin_addr), ntohs(cliaddr.sin_port));\n\n    return 0;\n}