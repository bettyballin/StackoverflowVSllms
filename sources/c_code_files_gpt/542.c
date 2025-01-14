#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8080
#define FILENAME "received_image.jpg"

void write_file(int sockfd) {
    int n;
    FILE *fp;
    char buffer[1024];

    fp = fopen(FILENAME, "wb");
    if (fp == NULL) {
        perror("[-] Error in opening file.");
        exit(1);
    }

    while ((n = recv(sockfd, buffer, 1024, 0)) > 0) {
        fwrite(buffer, sizeof(char), n, fp);
        memset(buffer, 0, 1024);
    }

    fclose(fp);
}

int main() {
    int sockfd;
    struct sockaddr_in server_addr;

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("[-] Error creating socket.");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(PORT);
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

    if (connect(sockfd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0) {
        perror("[-] Error connecting to server.");
        exit(1);
    }

    write_file(sockfd);
    printf("[+] Data received and saved successfully.\n");

    close(sockfd);

    return 0;
}