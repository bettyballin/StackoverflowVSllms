#include <stdio.h>
#include <arpa/inet.h>

int main() {
    char ip[16] = "84.52.184.224"; // IP address in standard format
    struct in_addr result;
    if (inet_pton(AF_INET, ip, &result) <= 0) {
        printf("Error: Invalid IP address\n");
        return -1;
    }
    // Print the resulting binary structure as a hexadecimal string
    printf("%lx\n", ntohl(result.s_addr));
    // or in decimal format
    printf("%ld\n", ntohl(result.s_addr));
    return 0;
}