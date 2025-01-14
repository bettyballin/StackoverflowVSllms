#include <sys/types.h>
#include <sys/socket.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

void handle_connection(int sockfd) {
    uid_t euid;
    gid_t egid;

    if (getpeereid(sockfd, &euid, &egid) == -1) {
        perror("getpeereid");
        exit(EXIT_FAILURE);
    }

    printf("Connected peer's effective UID: %d\n", euid);
    printf("Connected peer's effective GID: %d\n", egid);

    // Continue handling connection...
}

int main() {
    // Assume sockfd is a connected Unix-domain socket
    int sockfd;

    // Create a Unix-domain socket
    sockfd = socket(AF_UNIX, SOCK_STREAM, 0);
    if (sockfd == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Create a sockaddr_un structure
    struct sockaddr_un addr;
    memset(&addr, 0, sizeof(addr));
    addr.sun_family = AF_UNIX;
    strcpy(addr.sun_path, "/tmp/mysocket");

    // Connect to the socket
    if (connect(sockfd, (struct sockaddr *)&addr, sizeof(addr)) == -1) {
        perror("connect");
        exit(EXIT_FAILURE);
    }

    handle_connection(sockfd);

    close(sockfd);
    return 0;
}