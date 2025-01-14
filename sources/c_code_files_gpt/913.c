#include <linux/wireless.h>
#include <sys/ioctl.h>
#include <sys/socket.h>

int main() {
    int sockfd;
    struct iwreq request;

    // Create a socket
    sockfd = socket(AF_INET, SOCK_DGRAM, 0);

    // Set up request details
    // ... (you need to fill in the details here)

    // Perform the ioctl operation
    ioctl(sockfd, SIOCSIWSCAN, &request);

    return 0;
}