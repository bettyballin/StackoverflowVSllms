#include <stdio.h>
#include <string.h>
#include <linux/netfilter.h>
#include <libnetfilter_queue/pktbuff.h>
#include <libnetfilter_queue/nfqnl_queue.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <poll.h>

#define MAXWAIT 10

/* Returns the type of a TCP Packet (SYN, SYN-ACK, etc.) as an integer constant */
unsigned char get_tcp_flags(uint8_t * data) {
    return  ntohs(*((uint16_t*)data)) >> 12;
}

/* This is the callback that will be called for each packet. */
void cb(struct nfq_q_handle *queue, struct nfgenmsg *nfmsg,
        struct nfqnl_msg_pktinfo *pktinfo,
        void **data) {
    uint32_t type;
    uint8_t *pkt = (uint8_t*)*data;          // Copy of packet data.
    unsigned char tcp_flags = get_tcp_flags(pkt+14);   /* Get TCP Flags */

    /* If the packet is SYN, it's a new connection. Do whatever you want with that information */
    if ((tcp_flags & TH_SYN) && (! (tcp_flags & TH_ACK))) {
        // Processing for this packet... change destination, modify payload etc.
        printf( "New SYN Packet: source = %u.%u.%u.%u:%d --> dest = %u.%u.%u.%u:%d\n",
                (pkt[12] & 0xFF),                         // Source IP - Octet 3
                ((uint8_t *) pkt)[13],            // Octet 2
                ((uint8_t *) pkt)[14],            // Octet 1
               ( ((unsigned short *)(pkt+16))[0] >> 8 ),       // Dest Port - High byte
             (((unsigned short) *(pkt + 17))) & 0xFF         // Source Port - Low byte.
        );
    } else {
        printf("Skip Packet: Type = %d\n", tcp_flags);
    }
    // Drop packet to prevent original connection from being opened. If you don't want this behaviour replace NF_DROP with NF_ACCEPT below.
    __u32 cookie;                                // New field, ignored for now
    type = NFT_VERDICT(NF_DROP, "S", (uint64_t)PKTLEN); /* Drop this packet */
    nfqnl_pkt_set_verdict(queue, cookie, (unsigned short)(type));
}  // End callback function.

int main(void) {
    struct nfq_handle *h;
    struct nfq_q_handle *qh;
    nfq_callback cb;                            // Define Call back struct
    int fd;
    int rcvd;
    char pktdata[4096];

    h = nfq_open();                               /* Open NFQUEUE */
    if (!h) {
        printf("Error opening queue\n");
        exit(1);
    }

    nfq_unbind_pf(h, AF_INET);     /* Unbind existing handler */
    nfq_bind_pf(h, AF_INET);                /* Bind to IPv4 traffic */

    qh = nfq_create_queue(h, 0, &cb, NULL);   // Create queue for tcp/udp packets matching 'iptables' rule below.
    if (qh == NULL){
        printf("Failed creating queues\n");
        exit(1);
    }

    fd = nfq_fd(h);                             /* get a descriptor to use with select */
    int poll_timer = 0;
    struct pollfd pfd = {fd, POLLIN, 0};
    while (poll(&pfd, 1, -1) > 0 && ++poll_timer < MAXWAIT) {   // Wait for events on nfq.
        while ((rcvd = recv(fd, pktdata, sizeof(pktdata), MSG_DONTWAIT)) >0) {       // Get packet data
            nfq_handle_packet(h, (void *)pktdata, rcvd);    /* Send to callback */
        }  /* end while recv (rcvd > 0 ) */
    } /* end while poll time < MAXWAIT*/
    printf("End of Processing.\n");
    exit(1);
} // main()