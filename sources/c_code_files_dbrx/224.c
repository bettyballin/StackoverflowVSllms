#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main(){
    int sockfd = 0;
    struct sockaddr_in serv_addr;
    FILE *fp;
    char sendbuf[1024];
    char buf[50] = "file.jpg";
    int data; // declare data variable

    /* Socket creation */
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    memset(&serv_addr, 0, sizeof(serv_addr)); // fix memset syntax
    serv_addr.sin_family = AF_INET;
    // Change to suit destination IPv4 address
    inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr); // add IP address
    serv_addr.sin_port = htons(5000); /* Destination port */
    connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr));

    fp = fopen("file.jpg", "rb"); // Opening file in binary mode
    while ((data = getc(fp)) != EOF) /* Check if not end of file*/
    {
        send(sockfd, &data, sizeof(data), 0);  /* Sending the files */
    }
    fclose(fp); // close file pointer
    close(sockfd);
    return 0;
}