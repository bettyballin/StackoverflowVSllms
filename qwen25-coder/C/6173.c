#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <errno.h>\n#include <string.h>\n#include <netdb.h>\n#include <sys/types.h>\n#include <netinet/in.h>\n#include <sys/socket.h>\n\n#define PORT "1234" // the port client will be connecting to \n#define MAXDATASIZE 100 // max number of bytes we can get at once \n\nint main(int argc, char *argv[]) {\n    int sockfd, numbytes;  \n    char buf[MAXDATASIZE];\n    struct addrinfo hints, *servinfo, *p;\n    int rv;\n\n    if (argc != 2) {\n        fprintf(stderr,"usage: client hostname\n");\n        exit(1);\n    }\n\n    memset(&hints, 0, sizeof hints);\n    hints.ai_family = AF_UNSPEC; // don't care IPv4 or IPv6\n    hints.ai_socktype = SOCK_STREAM;\n\n    if ((rv = getaddrinfo(argv[1], PORT, &hints, &servinfo)) != 0) {\n        fprintf(stderr, "getaddrinfo: %s\n", gai_strerror(rv));\n        return 1;\n    }\n\n    // loop through all the results and connect to the first we can\n    for(p = servinfo; p != NULL; p = p->ai_next) {\n        if ((sockfd = socket(p->ai_family, p->ai_socktype,\n                             p->ai_protocol)) == -1) {\n            perror("client: socket");\n            continue;\n        }\n\n        if (connect(sockfd, p->ai_addr, p->ai_addrlen) == -1) {\n            close(sockfd);\n            perror("client: connect");\n            continue;\n        }\n\n        break;\n    }\n\n    freeaddrinfo(servinfo); // all done with this structure\n\n    if (p == NULL) {\n        fprintf(stderr, "client: failed to connect\n");\n        return 2;\n    }\n\n    printf("Connected to server.\n");\n\n    // Example of sending data\n    const char *msg = "Hello Server!\n";\n    send(sockfd, msg, strlen(msg), 0);\n\n    while (1) {\n        numbytes = recv(sockfd, buf, MAXDATASIZE-1, 0);\n        if (numbytes < 0) {\n            perror("recv");\n            close(sockfd);\n            return 1;\n        } else if (numbytes == 0) {\n            printf("Server closed the connection.\n");\n            break; // Connection closed by server\n        }\n        buf[numbytes] = '\0';\n        printf("Received: %s\n", buf);\n    }\n\n    close(sockfd);\n\n    return 0;\n}