#include <stdio.h>
#include <string.h>  // memset() function
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h>  // close() function

// Function to send an array of long integers over TCP.
void send_array(int socket, long arr[], int size) {
  write(socket, &size, sizeof(size));    //send the number of elements

  for (int i = 0; i < size; ++i) {
    write(socket, &arr[i], sizeof(long));   // Send each long integer value.
  }
}

int main() {
  int clientSocket, portNum = 8080; // Using port 8080 for the example
  struct sockaddr_in serverAddr;
  socklen_t addr_size;
  long arr[] = {1, 2, 3, 4, 5}; // Example array
  int size = sizeof(arr) / sizeof(arr[0]);

  // Create the client socket
  clientSocket = socket(AF_INET, SOCK_STREAM, 0);
  if (clientSocket < 0) {
    printf("Socket creation failed.\n");
    return -1;
  }

  // Set up the server address
  serverAddr.sin_family = AF_INET;
  inet_pton(AF_INET, "127.0.0.1", &(serverAddr.sin_addr)); // Connecting to localhost
  serverAddr.sin_port = htons(portNum);
  addr_size = sizeof(serverAddr);

  // Connect to the server
  if (connect(clientSocket, (struct sockaddr *)&serverAddr, addr_size) < 0) {
    printf("Connection failed.\n");
    return -1;
  }

  printf("Connected to the server successfully.\n");

  // Send the array
  send_array(clientSocket, arr, size);

  printf("Array sent successfully.\n");

  // Close the socket
  close(clientSocket);

  return 0;
}