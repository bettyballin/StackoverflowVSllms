#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <linux/if_packet.h>
#include <net/ethernet.h>
#include <errno.h>

int main() {
    int s;
    s = socket(PF_PACKET, SOCK_RAW, htons(ETH_P_ALL));
    if (s == -1) {
        perror("socket creation failed");
        return 1;
    }
    return 0;
}