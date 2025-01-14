#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <netlink/netlink.h>
#include <netlink/genl/genl.h>
#include <netlink/genl/ctrl.h>
#include <linux/nl80211.h>

static int callback(struct nl_msg *msg, void *arg) {
    struct genlmsghdr *gnlh = nlmsg_data(nlmsg_hdr(msg));

    struct nlattr *tb[NL80211_ATTR_MAX + 1];
    static struct nla_policy policy[NL80211_ATTR_MAX + 1] = {
        [NL80211_ATTR_BSS] = { .type = NLA_NESTED },
    };

    nla_parse(tb, NL80211_ATTR_MAX, genlmsg_attrdata(gnlh, 0), genlmsg_attrlen(gnlh, 0), policy);

    if (tb[NL80211_ATTR_BSS]) {
        printf("Found a new network\n");
        // Process the BSS attributes to extract SSID, channel, and encryption type
    }

    return NL_SKIP;
}

int main() {
    struct nl_sock *sock = nl_socket_alloc();
    if (!sock) {
        fprintf(stderr, "Failed to allocate netlink socket.\n");
        return -1;
    }

    if (genl_connect(sock)) {
        fprintf(stderr, "Failed to connect to generic netlink.\n");
        nl_socket_free(sock);
        return -1;
    }

    int driver_id = genl_ctrl_resolve(sock, "nl80211");
    if (driver_id < 0) {
        fprintf(stderr, "nl80211 not found.\n");
        nl_socket_free(sock);
        return -1;
    }

    struct nl_msg *msg = nlmsg_alloc();
    if (!msg) {
        fprintf(stderr, "Failed to allocate netlink message.\n");
        nl_socket_free(sock);
        return -1;
    }

    genlmsg_put(msg, 0, 0, driver_id, 0, 0, NL80211_CMD_GET_SCAN, 0);

    nla_put_u32(msg, NL80211_ATTR_IFINDEX, if_nametoindex("wlan0")); // Replace "wlan0" with your interface name

    nl_socket_modify_cb(sock, NL_CB_VALID, NL_CB_CUSTOM, callback, NULL);

    int ret = nl_send_auto_complete(sock, msg);
    if (ret < 0) {
        fprintf(stderr, "Failed to send message.\n");
        nlmsg_free(msg);
        nl_socket_free(sock);
        return -1;
    }

    nlmsg_free(msg);

    nl_recvmsgs_default(sock);

    nl_socket_free(sock);

    return 0;
}