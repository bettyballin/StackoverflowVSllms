#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netdb.h>
#include <arpa/inet.h>

#define PORT "8080" // Define the port number

int main() {
    struct addrinfo hints = {0};
    struct addrinfo *result = NULL, *rp = NULL;
    int sfd, s;

    hints.ai_family   = AF_INET;     // IPv4 address family
    hints.ai_socktype = SOCK_STREAM; // We want a TCP socket
    hints.ai_flags    = AI_PASSIVE;  // Fill in my IP for me (we're binding later)

    // Get the list of network interfaces and their addresses
    s = getaddrinfo(NULL, PORT, &hints, &result);
    if (s != 0) {
        fprintf(stderr, "getaddrinfo: %s\n", gai_strerror(s));
        exit(EXIT_FAILURE);
    }

    // Loop through each result to find non-loopback interface to bind with
    for (rp = result; rp != NULL; rp = rp->ai_next) {
        char ip[INET6_ADDRSTRLEN]; // IP address string buffer

        getnameinfo(rp->ai_addr, rp->ai_addrlen, ip, sizeof ip, NULL, 0, NI_NUMERICHOST);
        printf("IP: %s\n", ip);

        // If it's not a loopback interface and it has an IP address in the valid range for your system...
        if (!strchr(ip,'.') || atoi(ip) > 127) {
            break;
        }
    }

    if (rp == NULL) {
        printf("No valid interface found\n");
        exit(EXIT_FAILURE);
    }

    // Bind to chosen interface / port (if loop was completed, rp will be null and error printed instead)
    sfd = socket(rp->ai_family, rp->ai_socktype, rp->ai_protocol);
    if (sfd == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    if (bind(sfd, rp->ai_addr, rp->ai_addrlen) == -1) {
        perror("bind");
        exit(EXIT_FAILURE);
    }

    freeaddrinfo(result); // free the linked list

    return 0;
}