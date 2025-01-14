#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netdb.h>
#include <openssl/ssl.h>
#include <openssl/err.h>

int main() {
  int sock, result;
  struct addrinfo hints, *servinfo, *p;
  SSL_CTX *ctx = NULL;
  SSL *ssl = NULL;
  X509 *cert = NULL;
  const char *hostname = "www.example.com";
  const int port = 443; // HTTPS default port
  char msg[] = "GET / HTTP/1.0\r\n\r\n";

  memset(&hints, 0, sizeof hints);
  hints.ai_family = AF_UNSPEC;
  hints.ai_socktype = SOCK_STREAM;
  getaddrinfo(hostname, NULL, &hints, &servinfo);

  for (p = servinfo; p != NULL; p = p->ai_next) {
    if ((sock = socket(p->ai_family, p->ai_socktype, p->ai_protocol)) == -1) {
      perror("socket");
      continue;
    }
    if (connect(sock, p->ai_addr, p->ai_addrlen) == -1) {
      close(sock);
      perror("connect");
      continue;
    }
    break;
  }

  freeaddrinfo(servinfo);

  SSL_library_init();
  OpenSSL_add_all_algorithms();
  ERR_load_BIO_strings(); ERR_load_crypto_strings();
  SSL_load_error_strings();
  const SSL_METHOD *method = TLSv1_2_client_method();
  ctx = SSL_CTX_new(method);
  if (ctx == NULL) {
    perror("SSL_CTX_new");
    exit(-1);
  }
  ssl = SSL_new(ctx);
  SSL_set_fd(ssl, sock);
  result = SSL_connect(ssl);
  cert = SSL_get_peer_certificate(ssl);
  if (result != 1) {
    perror("SSL_connect");
    exit(-1);
  }

  SSL_write(ssl, msg, strlen(msg));

  char buf[1024];
  result = SSL_read(ssl, buf, sizeof(buf) - 1);
  if (result > 0) {
    while (result > 0) {
      printf("%.*s", result, buf);
      result = SSL_read(ssl, buf, sizeof(buf) - 1);
    }
  } else {
    printf("No response from server\n");
  }

  close(sock);
  if (cert != NULL) X509_free(cert);
  if (ctx != NULL) SSL_CTX_free(ctx);
  if (ssl != NULL) SSL_free(ssl);
  EVP_cleanup(); CRYPTO_cleanup_all_ex_data(); ERR_free_strings();
  return 0;
}