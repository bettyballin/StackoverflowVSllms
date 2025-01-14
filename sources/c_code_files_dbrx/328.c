#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <linux/if_packet.h>
#include <net/ethernet.h>     /* the L2 protocols */
#include <arpa/inet.h>        /* netinet/if_ether.h may be included for ether_aton only */
#include <net/if.h>           /* for if_nametoindex */

int main(void) {
    int s;
    struct sockaddr_ll addr;
    memset(&addr, 0x00, sizeof(struct sockaddr_ll));
    addr.sll_family = AF_PACKET;
    addr.sll_ifindex = if_nametoindex("eth0");
    addr.sll_protocol = htons(ETH_P_ALL);

    s = socket(AF_PACKET, SOCK_RAW, htons(ETH_P_ALL));
    bind(s,(struct sockaddr*)&addr,sizeof(struct sockaddr_ll));
    // ...
    return 0;
}