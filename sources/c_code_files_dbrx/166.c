#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/tcp.h>

int main() {
    int sock = socket(AF_INET, SOCK_STREAM, 0); // Create a TCP socket
    if (sock < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    int keepidle_time = 60;   // In seconds, set the interval between last data packet and first keepalive probe
    int max_probes_num = 5;   // Set maximum number of probes to be sent before declaring connection dead (TCP_KEEPCNT)
    int probe_tmo = 10;       // Interval time between the probing requests, if no response is received from peer (TCP_KEEPINTVL)

    /* Set the above options into your socket */
    if (setsockopt(sock, IPPROTO_TCP, TCP_KEEPCNT, &max_probes_num, sizeof max_probes_num) != 0) {
        perror("setsockopt TCP_KEEPCNT failed");
        exit(EXIT_FAILURE);
    }

    if (setsockopt(sock, IPPROTO_TCP, TCP_KEEPIDLE, &keepidle_time, sizeof keepidle_time) != 0) {
        perror("setsockopt TCP_KEEPIDLE failed");
        exit(EXIT_FAILURE);
    }

    if (setsockopt(sock, IPPROTO_TCP, TCP_KEEPINTVL, &probe_tmo, sizeof probe_tmo) != 0) {
        perror("setsockopt TCP_KEEPINTVL failed");
        exit(EXIT_FAILURE);
    }

    printf("TCP keepalive options set successfully on socket %d.\n", sock);

    // Remember to close the socket when you're done with it to free up resources.
    close(sock);

    return 0;
}