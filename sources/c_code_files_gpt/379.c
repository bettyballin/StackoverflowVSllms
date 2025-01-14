#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <sys/socket.h>
#include <linux/netlink.h>
#include <linux/rtnetlink.h>

#define BUFFER_SIZE 8192

void handle_netlink_message(struct nlmsghdr *nlh) {
    struct ifinfomsg *ifi;
    struct rtattr *rta;
    int len;

    ifi = NLMSG_DATA(nlh);
    rta = IFLA_RTA(ifi);
    len = IFLA_PAYLOAD(nlh);

    for (; RTA_OK(rta, len); rta = RTA_NEXT(rta, len)) {
        if (rta->rta_type == IFLA_IFNAME) {
            printf("Interface %s changed\n", (char *)RTA_DATA(rta));
        }
    }
}

int main() {
    int sock;
    struct sockaddr_nl addr;
    struct nlmsghdr *nlh;
    char buffer[BUFFER_SIZE];
    int len;

    sock = socket(AF_NETLINK, SOCK_RAW, NETLINK_ROUTE);
    if (sock < 0) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    memset(&addr, 0, sizeof(addr));
    addr.nl_family = AF_NETLINK;
    addr.nl_groups = RTMGRP_LINK;

    if (bind(sock, (struct sockaddr *)&addr, sizeof(addr)) < 0) {
        perror("bind");
        close(sock);
        exit(EXIT_FAILURE);
    }

    while (1) {
        len = recv(sock, buffer, sizeof(buffer), 0);
        if (len < 0) {
            perror("recv");
            close(sock);
            exit(EXIT_FAILURE);
        }

        for (nlh = (struct nlmsghdr *)buffer; NLMSG_OK(nlh, len); nlh = NLMSG_NEXT(nlh, len)) {
            if (nlh->nlmsg_type == NLMSG_DONE) {
                break;
            }
            if (nlh->nlmsg_type == NLMSG_ERROR) {
                fprintf(stderr, "Received error message\n");
                close(sock);
                exit(EXIT_FAILURE);
            }
            handle_netlink_message(nlh);
        }
    }

    close(sock);
    return 0;
}