#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h> // for htons and INADDR_ANY

#define PORT 12345

int main()
{
  struct sockaddr_in addr;
  int fd;

  fd = socket(AF_INET, SOCK_STREAM, 0);
  if(fd == -1)
  {
      printf("Error opening socket\n");
      return -1;
  }

  addr.sin_port = htons(PORT);
  addr.sin_addr.s_addr = INADDR_ANY;
  addr.sin_family = AF_INET;

  if(bind(fd, (struct sockaddr *)&addr,sizeof(struct sockaddr_in) ) == -1)
  {
      printf("Error binding socket\n");
      return -1;
  }

  printf("Successfully bound to port %u\n", PORT);
  return 0; // added return 0 to indicate successful execution
}