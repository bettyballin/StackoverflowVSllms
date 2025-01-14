#include <arpa/inet.h>
#include <netinet/ip.h>
#include <unistd.h>
#include <stdio.h> // for printf()
#include <stdlib.h> // for malloc()
#include <string.h> // for memset()
#include <sys/socket.h> // for socket()
#include <netinet/in.h> // for struct sockaddr_in
#include <sys/types.h> // for perror()
#include <errno.h> // for perror()

int set_df_flag(int sockfd) {
    int optval = 1; // For enabling DF flag
    return setsockopt(sockfd, IPPROTO_IP, IP_DONTFRAG, &optval, sizeof(optval));
}

void send_packet(uint32_t dest_ip) {
   int raw_socket = socket(AF_INET, SOCK_RAW, IPPROTO_RAW);

   if (raw_socket == -1) {
       perror("socket error");
       return;
   }

   struct sockaddr_in dest_addr;
   memset(&dest_addr, 0, sizeof(struct sockaddr_in));
   dest_addr.sin_family = AF_INET;
   dest_addr.sin_port = htons(12345); // Replace with UDP destination port
   dest_addr.sin_addr.s_addr = dest_ip;

   struct iphdr *ip_header = (struct iphdr *)malloc(sizeof(struct iphdr));
   memset(ip_header, 0, sizeof(struct iphdr));

   // Set DF flag to 1
   const int flags = htonl(IP_DF);
   union { uint32_t u32; struct iphdr i;} *u = (void*)&flags;
   printf("Flags set to: %d\n", u->i.frag_off & IP_OFFMASK); // Print the flags

   // Set up other IP header fields
   // ... (Fill in the rest of the IP header fields as needed)

   // Set the don't fragment flag
   int df = 1;
   set_df_flag(raw_socket);

   // Send packet with sendto()
   // ... (Fill in the rest of the sendto() call as needed)
   char buffer[1024];
   memset(buffer, 0, sizeof(buffer));
   socklen_t dest_len = sizeof(dest_addr);
   sendto(raw_socket, buffer, sizeof(buffer), 0, (struct sockaddr *)&dest_addr, dest_len);

   free(ip_header);
   close(raw_socket);
}

int main() {
   uint32_t dest_ip = inet_addr("192.168.1.100"); // Replace with destination IP address
   send_packet(dest_ip);
   return 0;
}