#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <unistd.h>

int main() {
    char my_sock[] = "/tmp/my_datagram-XXXXX";
    int fd = mkstemp(my_sock); // This generates a unique tmp name and opens the file.
    if (fd == -1) {
        perror("mkstemp");
        exit(1);
    }
    unlink(my_sock);           // Remove it from the filesystem but keep descriptor open.
    struct sockaddr_un addr;
    addr.sun_family = AF_UNIX;
    strcpy(addr.sun_path, my_sock);
    if (bind(fd, (struct sockaddr *)&addr, sizeof(addr)) == -1) {
        perror("bind");
        exit(1);
    }
    return 0;
}