#include <linux/netlink.h>
#include <linux/nl80211.h>
#include <linux/genl/genl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the send_and_recvmsgs function, which is not provided in the original code
static int send_and_recvmsgs(struct nl_sock *socket) {
    struct nl_msg *msg;
    struct nl_cb *cb;
    int err;

    msg = nlmsg_alloc();
    if (!msg) {
        printf("Failed to allocate netlink message\n");
        return -1;
    }

    cb = nl_cb_alloc(NL_CB_DEFAULT);
    if (!cb) {
        printf("Failed to allocate netlink callback\n");
        nlmsg_free(msg);
        return -1;
    }

    nl_cb_set(cb, NL_CB_VALID, NL_CB_CUSTOM, NULL, NULL);
    err = nl_send_auto_complete(socket, msg);
    if (err < 0) {
        printf("Failed to send netlink message: %d\n", err);
        nlmsg_free(msg);
        nl_cb_put(cb);
        return err;
    }

    err = nl_recvmsgs(socket, cb);
    if (err < 0) {
        printf("Failed to receive netlink message: %d\n", err);
    }

    nlmsg_free(msg);
    nl_cb_put(cb);
    return err;
}

int main() {
    // Define variables
    struct nlattr *tb[CTRL_ATTR_MAX + 1];
    struct nlmsghdr *nlp;
    struct nl_sock *socket;
    uint32_t nl80211id;

    // Create a netlink socket
    socket = nl_socket_alloc();
    if (!socket) {
        printf("Failed to allocate netlink socket\n");
        return -1;
    }

    // Connect to the generic netlink family
    nl_connect(socket, NETLINK_GENERIC);

    // Prepare the message
    socket->data = nla_put_string(socket, CTRL_ATTR_MCAST_GROUPS); /* Mcast groups are all families we know to listen for (mac80211) */

    // Send and receive messages
    send_and_recvmsgs(socket);

    // Save received message to structure
    nlp = socket->data;

    // Find NL80211 family ID
    tb[CTRL_ATTR_FAMILY_ID] = nla_find(nlp->nlmsg_attr, NL80211_WID);

    // Save found ID to global variable
    if (tb[CTRL_ATTR_FAMILY_ID]) {
        nl80211id = nla_getu32(tb[CTRL_ATTR_FAMILY_ID]);
    }

    // Clean up
    nl_socket_free(socket);

    return 0;
}