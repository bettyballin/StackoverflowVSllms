#include <arpa/inet.h>
#include <netinet/if_ether.h>
#include <pcap/pcap.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>  // For exit()

void processPacket(u_char *args, const struct pcap_pkthdr *header, u_char* packet){
    // Process your packets here...
}

int main() {
  char errbuf[PCAP_ERRBUF_SIZE];     // Error string buffer for PCap errors
  pcap_t *handle;                    // Handle to sniffed packet data
  struct bpf_program fp;             // Compiled filter program (expression)
  const u_char *packet;              // Pointer to the start of packet data
  struct pcap_pkthdr header;         // Packet header
  char filter_exp[] = "ip";           // The filter expression, in this case we want IP traffic only.

  // Open a live capture from network device, with a filter to limit what gets captured
  handle = pcap_open_live("eth0", BUFSIZ, 1, 1000, errbuf);    // Use eth0 for the demo purpose
  if (handle == NULL) {
      fprintf(stderr, "[!] Error opening device %s: %s\n", "eth0", errbuf);
      exit(EXIT_FAILURE);
  }

  // Compile and apply the filter to our handle so that we only sniff certain packets.
  if (pcap_compile(handle, &fp, filter_exp, 0, PCAP_NETMASK_UNKNOWN) == -1) {
      fprintf(stderr, "[!] Error compiling filter %s\n", filter_exp);
      exit(EXIT_FAILURE);
  }
  if (pcap_setfilter(handle, &fp) == -1) {
    fprintf(stderr, "[!] Error setting the filter: %s\n", pcap_geterr(handle));
     exit(EXIT_FAILURE);
   }

   // Loop indefinitely and print IP addresses for each packet received.
  while (true){
      packet = pcap_next(handle, &header);    // Get the next captured packet from our handle to get more data.
      if (packet) {                           // If we have a valid pointer...
          processPacket((u_char *)handle, &header, (u_char*)packet);     // Process your packets here inside this function...
       } else{
         fprintf(stderr, "[!] Error sniffing: %s\n", pcap_geterr(handle));
         break;   // Break on error (e.g., no more packets)
      }
  }

  pcap_close(handle);  // Close the pcap handle
  return 0;   // End the process and free resources
}