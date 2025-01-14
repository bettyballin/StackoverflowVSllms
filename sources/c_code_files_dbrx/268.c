#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>

int main() {
    // Create RAW socket
    int sock_raw = socket(AF_INET , SOCK_RAW , IPPROTO_TCP);
    if(sock_raw < 0)
    {
        // Print error message and exit
        perror("socket creation error");
        exit(1);
    }
    return 0;
}