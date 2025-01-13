#include <sys/socket.h>\n\n// Create a socket\nint sockfd = socket(AF_INET, SOCK_STREAM, 0);\n\n// Set the send buffer size to 1MB\nint sndbufsize = 1024 * 1024;\nsetsockopt(sockfd, SOL_SOCKET, SO_SNDBUF, &sndbufsize, sizeof(sndbufsize));\n\n// Set the receive buffer size to 1MB\nint rcvbufsize = 1024 * 1024;\nsetsockopt(sockfd, SOL_SOCKET, SO_RCVBUF, &rcvbufsize, sizeof(rcvbufsize));