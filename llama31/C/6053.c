// Client side\nint sockfd = socket(AF_INET, SOCK_STREAM, 0);\nstruct sockaddr_in serv_addr;\nserv_addr.sin_family = AF_INET;\nserv_addr.sin_port = htons(8080);\ninet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr);\n\n// Call connect()\nconnect(sockfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr));\n\n// At this point, the connection is established and we can call send() and recv()\nsend(sockfd, "Hello", 5, 0);\nrecv(sockfd, buffer, 1024, 0);