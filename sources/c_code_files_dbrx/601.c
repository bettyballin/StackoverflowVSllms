#include <sys/socket.h>

int main() {
    int sock = socket(AF_INET, SOCK_STREAM, 0);
    socklen_t optVal = 128 * 1024; // <-- desired receiver/sender buffer length in bytes
    setsockopt(sock, SOL_SOCKET, SO_RCVBUF, &optVal, sizeof(optVal));
    // ... and the same for sender using SO_SNDBUF.
    setsockopt(sock, SOL_SOCKET, SO_SNDBUF, &optVal, sizeof(optVal));
    return 0;
}