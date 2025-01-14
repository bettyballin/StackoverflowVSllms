#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    int fd = socket(AF_INET, SOCK_STREAM, 0);
    if (fd < 0) {
        perror("socket creation failed");
        return 1;
    }

    char my_sock[] = "\0abcde";
    bind(fd, (const struct sockaddr *) &my_sock, sizeof(my_sock));

    return 0;
}