#include <sys/types.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#define SOCKET_PATH "/tmp/socket"

void recvfd(int socket_fd);

int main(int argc, char *argv[]) {
    int server_fd, client_fd;
    struct sockaddr_un addr;

    // Create a Unix domain socket
    if ((server_fd = socket(AF_UNIX, SOCK_STREAM, 0)) == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Bind the socket to a file path
    memset(&addr, 0, sizeof(addr));
    addr.sun_family = AF_UNIX;
    strncpy(addr.sun_path, SOCKET_PATH, sizeof(addr.sun_path) - 1);
    unlink(SOCKET_PATH);

    if (bind(server_fd, (struct sockaddr *)&addr, sizeof(addr)) == -1) {
        perror("bind");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Listen for incoming connections
    if (listen(server_fd, 5) == -1) {
        perror("listen");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Accept a connection from a client
    if ((client_fd = accept(server_fd, NULL, NULL)) == -1) {
        perror("accept");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Receive the file descriptor from the client
    recvfd(client_fd);

    close(client_fd);
    close(server_fd);
    unlink(SOCKET_PATH);
    return 0;
}

void recvfd(int socket_fd) {
    struct msghdr msg = {0};
    struct cmsghdr *cmsg;
    char buf[CMSG_SPACE(sizeof(int))];
    char dummy[1];
    struct iovec io = { .iov_base = dummy, .iov_len = sizeof(dummy) };
    int received_fd;

    msg.msg_iov = &io;
    msg.msg_iovlen = 1;
    msg.msg_control = buf;
    msg.msg_controllen = sizeof(buf);

    if (recvmsg(socket_fd, &msg, 0) < 0) {
        perror("recvmsg");
        exit(EXIT_FAILURE);
    }

    cmsg = CMSG_FIRSTHDR(&msg);
    if (cmsg && cmsg->cmsg_len == CMSG_LEN(sizeof(int)) && cmsg->cmsg_level == SOL_SOCKET && cmsg->cmsg_type == SCM_RIGHTS) {
        received_fd = *((int *) CMSG_DATA(cmsg));
        printf("Received file descriptor: %d\n", received_fd);
    } else {
        printf("Failed to receive file descriptor\n");
    }
}