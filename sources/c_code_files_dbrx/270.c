#include <asm/types.h>
#include <linux/netlink.h>
#include <linux/rtnetlink.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <unistd.h>

int main() {
    struct sockaddr_nl sa; // for sending to the kernel
    int rtnlfd, ifinfomsg_len, flags = 0, seq = 1234567890, pid;
    char buffer[8192] __attribute__ ((aligned)); // aligned for netlink
    struct iovec iov = { buffer, sizeof(buffer) };
    struct msghdr msg = { &sa, sizeof(struct sockaddr_nl), &iov, 1, NULL, 0, 0 };
    rtnlfd = socket(AF_NETLINK, SOCK_DGRAM | SOCK_CLOEXEC, NETLINK_ROUTE);

    if (rtnlfd < 0) {
        perror("socket");
        return 1;
    }

    memset(&sa, 0, sizeof(struct sockaddr_nl));
    sa.nl_family = AF_NETLINK;
    sa.nl_groups |= RTMGRP_LINK | RTMGRP_IPV4_IFADDR | RTMGRP_IPV6_IFADDR; // listen to these groups
    if (bind(rtnlfd, (struct sockaddr *)&sa, sizeof(struct sockaddr)) < 0) {
        perror("bind");
        return 1;
    }

    while (1) {
        ssize_t len = recvmsg(rtnlfd, &msg, flags);
        if (len < 0) { 
            perror("recvmsg"); 
            continue; 
        } // handle error or exit on fatal error...
        int msgs; 
        struct nlmsghdr *nh; 
        char *ptr; 
        int type;
        msgs = len / sizeof(struct nlmsghdr); //nlh is the start of a messege.
        for (nh= (struct nlmsghdr *)buffer, ptr= (char *)buffer+NLMSG_ALIGN(len) ;
             NLMSG_OK((*nh),(int)(ptr- (char *)nh)) && msgs>0;
                    nh=(struct nlmsghdr *)(void*) ((char *)nh + NLMSG_ALIGN(nh->nlmsg_len)), msgs--) { // loop through all messages
             type = (*nh).nlmsg_type; /* message type (request or response */ 
        }
    }
    close(rtnlfd);
    return 0;
}