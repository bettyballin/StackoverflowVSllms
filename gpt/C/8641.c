#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <unistd.h>\n#include <arpa/inet.h>\n\n#define PORT 8080\n#define CHUNK_SIZE 1048576 // 1MB\n\nint main() {\n    int server_fd, new_socket;\n    struct sockaddr_in address;\n    int opt = 1;\n    int addrlen = sizeof(address);\n    char buffer[CHUNK_SIZE] = {0};\n\n    // Fill buffer with dummy data\n    memset(buffer, 'A', CHUNK_SIZE);\n\n    // Creating socket file descriptor\n    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) {\n        perror("socket failed");\n        exit(EXIT_FAILURE);\n    }\n\n    // Forcefully attaching socket to the port 8080\n    if (setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR | SO_REUSEPORT, &opt, sizeof(opt))) {\n        perror("setsockopt");\n        close(server_fd);\n        exit(EXIT_FAILURE);\n    }\n\n    address.sin_family = AF_INET;\n    address.sin_addr.s_addr = INADDR_ANY;\n    address.sin_port = htons(PORT);\n\n    // Forcefully attaching socket to the port 8080\n    if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {\n        perror("bind failed");\n        close(server_fd);\n        exit(EXIT_FAILURE);\n    }\n    if (listen(server_fd, 3) < 0) {\n        perror("listen");\n        close(server_fd);\n        exit(EXIT_FAILURE);\n    }\n    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen)) < 0) {\n        perror("accept");\n        close(server_fd);\n        exit(EXIT_FAILURE);\n    }\n\n    // Send 1MB of data\n    if (write(new_socket, buffer, CHUNK_SIZE) < 0) {\n        perror("write");\n        close(new_socket);\n        close(server_fd);\n        exit(EXIT_FAILURE);\n    }\n\n    printf("1MB of data sent successfully\n");\n\n    close(new_socket);\n    close(server_fd);\n    return 0;\n}