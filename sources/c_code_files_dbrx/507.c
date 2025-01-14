#include <stdio.h>
#include <string.h>
#include <sys/socket.h>

int main() {
    int sockfd;
    char buffer[] = "Hello, World!";
    
    // Assume sockfd is a valid socket file descriptor
    int bytes_written = write(sockfd, buffer, strlen(buffer));
    
    if (bytes_written < 0) {
        perror("write");
    } else {
        printf("Wrote %d bytes to socket\n", bytes_written);
    }
    
    return 0;
}