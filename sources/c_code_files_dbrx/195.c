#include <stdio.h>
#include <string.h> // For strcmp() function
#include <unistd.h> // for close(), read, write...
#include <fcntl.h>  // for open(0_RDONLY or O_WRONLY)
#include <sys/socket.h>    /* socket, bind, listen, accept */
#include <arpa/inet.h>     /* struct sockaddr_in */
#include <strings.h>       /*bzero()*/
#define PORT 8080 // You can choose your own port number here

void serveRequest(int newSocketFD) {
    char buffer[256];      // The buffer where we read data from the clients socket
    bzero((char *) &buffer, sizeof(buffer));   /* clear out the buffer */
    int bytesReceived = read(newSocketFD, buffer, sizeof(buffer)-1);  // Read until end of message is reached

    if (bytesReceived < 0) {
        perror("Error reading. Closing this connection\n");     /* Print error */
        close(newSocketFD);   /* Close the clients socket */
        return;          /* Exit */
    }

    // AJAX request should have Content-Type: application/json header in it's HTTP request
    if (strstr(buffer, "Content-Type: application/json") != NULL) {
        printf("This is an AJAX Request\n");  /* Print info message */
        // Your C code here to handle the request and send appropriate HTTP response
        // ...
        // For example sending back a simple JSON object in the body of your http message: {"status": "200"}
        char* response = "HTTP/1.1 200 OK\r\nContent-Type: application/json; charset=UTF-8\r\n\r\n{\"status\": \"200\"}";
        write(newSocketFD, response, strlen(response)); // write()'s return value is the length of message we wrote.
    } else {
        printf("This is not an AJAX Request\n");  /* Print info */
        // Handle other types of request, if necessary.
        // You can choose to close this connection or respond differently as you wish.
    }
}

int main(void) {
    struct sockaddr_in serverInfo, clientInfo;  /* Structure describing an Internet socket address.*/
    int newSocketFD;                           // The descriptor of the new file we will communicate through.
    socklen_t addrSize = sizeof(struct sockaddr_in);  /* This should always be set to 16 (sizeof), but is declared for clarity */
    /* Allocate Internet address structure. */
    bzero(&serverInfo, sizeof(serverInfo));    // Initialize the struct with zeroes using memset() or bzero()
    /* Clear out the structure */
    serverInfo.sin_family = AF_INET;              /** The protocol (communications) family to use **/
    serverInfo.sin_port = htons(PORT);           /* Port we are listening on */
    /* Host-to-network byte order conversion with htons(). This is necessary if you want your app to work correctly on big and little endian architectures...*/
    /*** Set the local interface IP address to loop back (localhost i.e 127.0.0.1) ***/
    serverInfo.sin_addr.s_addr = htonl(INADDR_LOOPBACK); // Convert to network byte order with htonl()
    /* Initialize the client's struct addrinfo to zero */
    bzero(&clientInfo, sizeof(clientInfo));         /** Clear out the structure **/
    /* Create an unnamed local socket  (TCP)
     * AF_INET = IPv4 Internet protocol
     * SOCK_STREAM: provides sequenced, reliable, full-duplex, connection-based byte streams.
     * (TCP would be used over IP.) */
    int socketFD = socket(AF_INET, SOCK_STREAM|SOCK_NONBLOCK, 0);  /* The non block flag is set with SOCK_NONBLOCK so our server can handle multiple connections simultaneously
     * Non-blocking means we won't wait on read() or write(), which would otherwise stall our program from receiving any other requests until one finishes. */
    if (socketFD < 0) {
        perror("Problem creating the socket.\n");       /* Error handling, print a message and exit...*/
        return -1;                 // Return with error code
    }
    /* Set up my own address */
    int bindStatus = bind(socketFD,(struct sockaddr*)&serverInfo, sizeof(serverInfo));  // Use the server's info to set its' socket.
    if (bindStatus < 0) {
        perror("Cannot bind to this address.\n"); /* Error handling */
        close(socketFD);        // Close and error out
        return -1;              // Return with an error code
    } else printf("Bind successful!\n");  // Success message when binding was correct.
    listen(socketFD, 5);    /** Allow connections from multiple clients (max of 5) */
    int loopFlag = 1;       /* Loop flag to decide whether we will keep listening for other incoming requests or not*/
    while(loopFlag > 0){
        printf("Waiting for new connection!\n"); // Print message
        bzero(&clientInfo, sizeof(clientInfo));      /** Clear out the structure **/
        while((newSocketFD = accept(socketFD ,(struct sockaddr*) &clientInfo, (socklen_t *)&addrSize))>=0){ /* Server is waiting and if a client tries to connect this will happen then */
            printf("New incoming connection from %s\n", inet_ntoa((struct in_addr)clientInfo.sin_addr));  // Print info message with address of the new connected client
            serveRequest(newSocketFD);                           /* Call function to serve request*/
        };/*close while loop for accept */ printf("accept() error or we chose not to listen no more.\n");//end of connections as per programmer's choice, can also be due to errors....
    }/*** This is the server loop that accepts incoming connections and serves them by calling serveRequest(). ****/ // End of while (loop) for main loop.
    close(socketFD);     /* Close the socket */   return 0; }  /** Signify successful execution **/