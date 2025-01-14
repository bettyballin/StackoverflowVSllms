#include <stdio.h>
#include <stdlib.h>
#include <linux/genetlink.h>
#include <linux/nl80211.h>
#include <netlink/genl/genl.h>
#include <netlink/genl/family.h>
#include <netlink/genl/ctrl.h>

int main() {
    struct nl_sock *socket;
    struct nl_msg *m;
    int nl80211id;
    int ifindex;
    int cmd;
    struct nlmsghdr *nlp;

    // Initialize the netlink socket
    socket = nl_socket_alloc();
    if (!socket) {
        printf("Failed to allocate netlink socket\n");
        return -1;
    }

    // Connect to the netlink socket
    if (nl_connect(socket, NETLINK_GENERIC)) {
        printf("Failed to connect to netlink socket\n");
        nl_socket_free(socket);
        return -1;
    }

    // Get the nl80211 family ID
    nl80211id = genl_family_get_id(socket, "nl80211");
    if (nl80211id < 0) {
        printf("Failed to get nl80211 family ID\n");
        nl_socket_free(socket);
        return -1;
    }

    // Allocate space for the message
    m = nlmsg_alloc();
    if (!m) {
        printf("Failed to allocate message buffer\n");
        nl_socket_free(socket);
        return -1;
    }

    // Fill in the message fields
    genlmsg_put(m, 0, 0, genl_family_get_id(socket, "nl80211"), 0, NLM_F_REQUEST);
    nla_put_u32(m, NL80211_ATTR_IFINDEX, ifindex);
    nla_put_u32(m, CTRL_ATTR_CMD, cmd);

    // Finalize the message
    nlmsg_end(m, NLMSG_ALIGN(nlmsg_hdr_len(m)));

    // Send and receive the message
    send_and_recvmsgs(socket);

    // Save the received message to a structure
    nlp = nlmsg_hdr(socket->data);

    // Now inspect the contents of your response using `nlmsg_*` and `nla_*` functions.

    // Clean up
    nlmsg_free(m);
    nl_socket_free(socket);

    return 0;
}