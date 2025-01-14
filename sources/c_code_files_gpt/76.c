#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <unistd.h>
#include <sys/wait.h>  // Added for waitpid function
#include <string.h>    // Added for memset function
#include <errno.h>     // Added for perror function

#define SOCKET_PATH "/tmp/ui_server.sock"

// Function to handle SIGCHLD signal
void handle_sigchld(int sig) {
    int status;
    pid_t pid;

    // Wait for all children that have terminated
    while ((pid = waitpid(-1, &status, WNOHANG)) > 0) {
        printf("Client process %d terminated\n", pid);
        // Perform cleanup for resources allocated by this client process
        cleanup_resources(pid);
    }
}

// Function to cleanup resources
void cleanup_resources(pid_t pid) {
    // Implement resource cleanup logic here
    printf("Cleaning up resources for client process %d\n", pid);
}

int main() {
    int server_fd, client_fd;
    struct sockaddr_un addr;

    // Set up SIGCHLD handler
    struct sigaction sa;
    sa.sa_handler = handle_sigchld;
    sigemptyset(&sa.sa_mask);
    sa.sa_flags = SA_RESTART;
    if (sigaction(SIGCHLD, &sa, NULL) == -1) {
        perror("sigaction");
        exit(EXIT_FAILURE);
    }

    // Create a Unix domain socket
    if ((server_fd = socket(AF_UNIX, SOCK_STREAM, 0)) == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Set up the socket address
    memset(&addr, 0, sizeof(addr));
    addr.sun_family = AF_UNIX;
    strncpy(addr.sun_path, SOCKET_PATH, sizeof(addr.sun_path) - 1);

    // Bind the socket to the address
    if (bind(server_fd, (struct sockaddr*)&addr, sizeof(addr)) == -1) {
        perror("bind");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Listen for connections
    if (listen(server_fd, 5) == -1) {
        perror("listen");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    printf("UI server is running...\n");

    // Accept client connections
    while ((client_fd = accept(server_fd, NULL, NULL)) != -1) {
        printf("Client connected\n");

        // Fork a new process to handle the client
        pid_t pid = fork();
        if (pid == -1) {
            perror("fork");
            close(client_fd);
        } else if (pid == 0) {
            // Child process: handle client communication
            close(server_fd);
            // Handle client communication here
            printf("Handling client communication...\n");
            exit(EXIT_SUCCESS);
        } else {
            // Parent process
            close(client_fd);
        }
    }

    close(server_fd);
    unlink(SOCKET_PATH);
    return 0;
}