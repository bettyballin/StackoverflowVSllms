# Example test case from Linux Kernel\n# File: tools/testing/selftests/net/tcp_fastopen.c\n#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <sys/socket.h>\n#include <netinet/in.h>\n#include <arpa/inet.h>\n\nint main(int argc, char **argv)\n{\n    int sockfd, connfd;\n    struct sockaddr_in servaddr, cliaddr;\n    socklen_t clilen;\n\n    sockfd = socket(AF_INET, SOCK_STREAM, 0);\n    if (sockfd < 0) {\n        perror("socket");\n        exit(EXIT_FAILURE);\n    }\n\n    // ...\n}