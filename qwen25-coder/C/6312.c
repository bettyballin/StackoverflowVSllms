#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <unistd.h>\n#include <arpa/inet.h>\n\n#define PORT 8080\n\nvoid udp_server(int family) {\n    int sockfd;\n    struct sockaddr_storage servaddr, cliaddr;\n    socklen_t len = sizeof(cliaddr);\n    char buffer[1024];\n\n    // Creating socket file descriptor\n    if ((sockfd = socket(family, SOCK_DGRAM, 0)) < 0) {\n        perror("socket creation failed");\n        exit(EXIT_FAILURE);\n    }\n\n    memset(&servaddr, 0, sizeof(servaddr));\n    memset(&cliaddr, 0, sizeof(cliaddr));\n\n    // Filling server information\n    servaddr.ss_family = family;\n    if (family == AF_INET) {\n        ((struct sockaddr_in *)&servaddr)->sin_port = htons(PORT);\n        inet_pton(AF_INET, "0.0.0.0", &((struct sockaddr_in *)&servaddr)->sin_addr);\n    } else {\n        ((struct sockaddr_in6 *)&servaddr)->sin6_port = htons(PORT);\n        inet_pton(AF_INET6, "::", &((struct sockaddr_in6 *)&servaddr)->sin6_addr);\n    }\n\n    // Bind the socket with the server address\n    if (bind(sockfd, (const struct sockaddr *)&servaddr, sizeof(servaddr)) < 0) {\n        perror("bind failed");\n        exit(EXIT_FAILURE);\n    }\n\n    printf("Listening on %s port %d\n", family == AF_INET ? "IPv4" : "IPv6", PORT);\n\n    while (1) {\n        int n = recvfrom(sockfd, buffer, sizeof(buffer), 0,\n                         (struct sockaddr *)&cliaddr, &len);\n        if (n < 0) {\n            perror("Error receiving packet");\n            continue;\n        }\n        printf("Received packet: %s\n", buffer);\n\n        // Echo the message back to client\n        sendto(sockfd, buffer, n, 0,\n               (const struct sockaddr *)&cliaddr, len);\n    }\n\n    close(sockfd);\n}\n\nint main() {\n    udp_server(AF_INET);  // Start a UDP server for IPv4\n    udp_server(AF_INET6); // Start a UDP server for IPv6\n\n    return 0;\n}