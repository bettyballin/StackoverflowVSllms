#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8080
#define FILENAME "image.jpg"

void send_file(FILE *fp, int sockfd) {
    char data[1024] = {0};

    while (fread(data, sizeof(char), 1024, fp) > 0) {
        if (send(sockfd, data, sizeof(data), 0) == -1) {
            perror("[-] Error in sending file.");
            exit(1);
        }
        memset(data, 0, 1024);
    }
}

int main() {
    int sockfd, new_sock;
    struct sockaddr_in server_addr, new_addr;
    socklen_t addr_size;
    char buffer[1024];
    FILE *fp;

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("[-] Error in creating socket.");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(PORT);
    server_addr.sin_addr.s_addr = INADDR_ANY;

    if (bind(sockfd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0) {
        perror("[-] Error in binding port.");
        exit(1);
    }

    if (listen(sockfd, 10) < 0) {
        perror("[-] Error in listening.");
        exit(1);
    }

    addr_size = sizeof(new_addr);
    new_sock = accept(sockfd, (struct sockaddr*)&new_addr, &addr_size);
    if (new_sock < 0) {
        perror("[-] Error in accepting connection.");
        exit(1);
    }

    fp = fopen(FILENAME, "rb");
    if (fp == NULL) {
        perror("[-] Error in reading file.");
        exit(1);
    }

    send_file(fp, new_sock);
    printf("[+] File data sent successfully.\n");

    fclose(fp);
    close(new_sock);
    close(sockfd);

    return 0;
}