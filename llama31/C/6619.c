#include <libnl3/netlink.h>\n#include <libnl3/genl/genl.h>\n#include <libnl3/genl/ctrl.h>\n\n// Define a callback function to handle notifications\nstatic int handle_notification(struct nl_msg *msg, void *arg) {\n    struct genlmsghdr *gnlh = nlmsg_data(nlmsg_hdr(msg));\n    struct nlattr *attr;\n\n    // Iterate over the attributes in the notification\n    nla_for_each_attr(attr, genlmsg_attrdata(gnlh, 0), genlmsg_attrlen(gnlh, 0), 0) {\n        if (nla_type(attr) == NL80211_ATTR_SSID) {\n            // Extract the network name (SSID)\n            char ssid[nla_len(attr) + 1];\n            nla_memcpy(ssid, nla_data(attr), nla_len(attr));\n            ssid[nla_len(attr)] = '\0';\n\n            printf("Network name: %s\n", ssid);\n        } else if (nla_type(attr) == NL80211_ATTR_WIPHY_FREQ) {\n            // Extract the channel frequency\n            uint32_t freq = nla_get_u32(attr);\n            printf("Channel frequency: %u MHz\n", freq);\n        } else if (nla_type(attr) == NL80211_ATTR_CIPHER_SUITE_GROUP) {\n            // Extract the encryption type (cipher suite)\n            uint32_t cipher_suite = nla_get_u32(attr);\n            printf("Encryption type: %u\n", cipher_suite);\n        }\n    }\n\n    return NL_OK;\n}\n\nint main() {\n    struct nl_sock *sk;\n    struct nl_msg *msg;\n\n    // Create a netlink socket\n    sk = nl_socket_alloc();\n    nl_connect(sk, NETLINK_GENERIC);\n\n    // Subscribe to nl80211 notifications\n    msg = nlmsg_alloc();\n    genlmsg_put(msg, NL_AUTO_PORT, NL_AUTO_SEQ, NL80211_GENL_NAME, 0, 0, NL80211_CMD_GET_SCAN, 0);\n    nl_send_auto_complete(sk, msg);\n\n    // Set up the callback function to handle notifications\n    nl_socket_modify_cb(sk, NL_CB_MSG_IN, NL_CB_CUSTOM, handle_notification, NULL);\n\n    // Start receiving notifications\n    nl_recvmsgs_default(sk);\n\n    return 0;\n}