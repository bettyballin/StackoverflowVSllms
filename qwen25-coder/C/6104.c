#include <openssl/ssl.h>\n#include <openssl/err.h>\n#include <netinet/in.h>\n#include <sys/socket.h>\n\nSSL_CTX* InitClientCTX(void) {\n   const SSL_METHOD *method;\n   SSL_CTX *ctx;\n\n   OpenSSL_add_all_algorithms();  /* Load cryptos, et.al. */\n   SSL_load_error_strings();   /* Bring in and register error messages */\n   method = TLS_client_method();  /* Create new client-method instance */\n   ctx    = SSL_CTX_new(method);   /* Create new context */\n\n   if (ctx == NULL) {\n      ERR_print_errors_fp(stderr);\n      abort();\n   }\n   return ctx;\n}\n\nvoid ShowCerts(SSL* ssl) {   \n   X509 *cert;\n   char *line;\n\n   cert = SSL_get_peer_certificate(ssl); // Get certificates (if available)\n   if (cert != NULL) {\n      printf("Server certificates:\n");\n      line=X509_NAME_oneline(X509_get_subject_name(cert), 0, 0);\n      printf("Subject: %s\n", line);\n      free(line);\n      line=X509_NAME_oneline(X509_get_issuer_name(cert), 0, 0);\n      printf("Issuer: %s\n", line);\n      free(line);\n      X509_free(cert);\n   } else\n      printf("No certificates.\n");\n}\n\nint SecureConnect(char* hostname) {\n    int sockfd;\n\n    SSL_library_init();\n\n    SSL_CTX *ctx = InitClientCTX();\n    struct sockaddr_in servaddr;\n   \n    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)\n        perror("socket error");\n \n    memset(&servaddr, 0, sizeof(servaddr));\n    servaddr.sin_family = AF_INET;\n    servaddr.sin_port = htons(4321);\n  \n    inet_pton(AF_INET, hostname, &servaddr.sin_addr);\n\n    // connect to server\n    if (connect(sockfd, (SA*)&servaddr, sizeof(servaddr)) < 0)\n        perror("connect error");\n\n    SSL *ssl = SSL_new(ctx);      /* create new SSL connection state */\n    SSL_set_fd(ssl, sockfd);      /* attach the socket descriptor */\n\n    // Perform SSL/TLS handshake\n    if (SSL_connect(ssl) == -1) {\n        ERR_print_errors_fp(stderr);\n        close(sockfd);\n        SSL_free(ssl);\n        return 0;\n    }else{\n        printf("Connected with %s encryption\n", SSL_get_cipher(ssl));\n        ShowCerts(ssl);       // get any certificates\n    }\n\n    /* message loop */\n    char msg[1024];\n    while ((fgets(msg, sizeof(msg), stdin))) {\n        SSL_write(ssl, msg, strlen(msg));   /* encrypt & send message */\n        int bytes = SSL_read(ssl, msg, sizeof(msg)-1); /* get reply & decrypt */\n        msg[bytes] = 0;\n        printf("Received: \"%s\"\n", msg);\n    }\n\n    SSL_free(ssl);        // release connection state\n    close(sockfd);         // close socket\n    cleanup(ctx);\n}\n\nint main(int argc, char* argv[]) {\n\n   SecureConnect(argv[1]); // The argument should be the IP address of your server\n\n}