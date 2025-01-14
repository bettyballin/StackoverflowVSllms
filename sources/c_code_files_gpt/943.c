#include <stdio.h>
#include <stdlib.h>

int check_server_route(const char *server_ip) {
    char command[256];
    snprintf(command, sizeof(command), "ping -c 1 %s > /dev/null 2>&1", server_ip);
    int status = system(command);
    return (status == 0);
}

int main() {
    const char *server_ip = "8.8.8.8"; // example IP address
    int result = check_server_route(server_ip);
    printf("Server route check result: %d\n", result);
    return 0;
}