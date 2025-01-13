#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <sys/socket.h>\n#include <linux/rtnetlink.h>\n\n// ...\n\nint sock = socket(AF_NETLINK, SOCK_RAW, NETLINK_ROUTE);\nif (sock < 0) {\n    perror("socket");\n    exit(1);\n}\n\nstruct sockaddr_nl addr;\nmemset(&addr, 0, sizeof(addr));\naddr.nl_family = AF_NETLINK;\naddr.nl_groups = RTMGRP_LINK;\n\nif (bind(sock, (struct sockaddr *)&addr, sizeof(addr)) < 0) {\n    perror("bind");\n    exit(1);\n}\n\n// ...\n\nwhile (1) {\n    char buf[4096];\n    struct nlmsghdr *nh;\n    int len = recv(sock, buf, sizeof(buf), 0);\n    if (len < 0) {\n        perror("recv");\n        break;\n    }\n\n    nh = (struct nlmsghdr *)buf;\n    if (nh->nlmsg_type == RTM_NEWLINK || nh->nlmsg_type == RTM_DELLINK) {\n        // Update your list of network interfaces here\n        printf("Network interface change detected\n");\n        // ...\n    }\n}