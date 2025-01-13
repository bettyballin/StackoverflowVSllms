#include <sys/types.h>\n#include <sys/socket.h>\n#include <sys/un.h>\n#include <unistd.h>\n#include <stdio.h>\n#include <errno.h>\n\n#define UNIX_PATH_MAX 108\n\nint main(int argc, char *argv[]) {\n    int sv[2];\n    if (socketpair(AF_UNIX, SOCK_STREAM, 0, sv) == -1) {\n        perror("socketpair");\n        return 1;\n    }\n    close(sv[1]); // Close the client side in server\n    recvfd(sv[0]);\n    close(sv[0]);\n    return 0;\n}\n\nvoid recvfd(int sockfd) {\n    struct msghdr msg = {0};\n    char m_buffer[1];\n    char c_buffer[CMSG_SPACE(sizeof(int))];\n    struct iovec io = {.iov_base = m_buffer, .iov_len = sizeof(m_buffer)};\n\n    msg.msg_iov = &io;\n    msg.msg_iovlen = 1;\n    msg.msg_control = c_buffer;\n    msg.msg_controllen = sizeof(c_buffer);\n\n    if (recvmsg(sockfd, &msg, 0) < 0) {\n        perror("recvmsg");\n        return;\n    }\n\n    struct cmsghdr *cmsg = CMSG_FIRSTHDR(&msg);\n    int fd = *(int *)CMSG_DATA(cmsg);\n\n    printf("Received fd: %d\n", fd);\n}