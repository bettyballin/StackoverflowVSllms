int on = 1;\nsetsockopt(sock4_raw, IPPROTO_IP, IP_HDRINCL, (char *)&on, sizeof(on));