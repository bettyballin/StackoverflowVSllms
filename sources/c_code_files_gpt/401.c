#include <pcap.h>
#include <stdio.h>

void packet_handler(u_char *user, const struct pcap_pkthdr *header, const u_char *packet) {
    printf("Packet captured: length %d\n", header->len);
}

int main() {
    char errbuf[PCAP_ERRBUF_SIZE];
    pcap_t *handle;

    // Open the device for capturing
    handle = pcap_open_live("eth0", BUFSIZ, 1, 1000, errbuf);
    if (handle == NULL) {
        fprintf(stderr, "Could not open device: %s\n", errbuf);
        return 2;
    }

    // Start the packet capture loop
    pcap_loop(handle, 10, packet_handler, NULL);

    // Close the handle
    pcap_close(handle);
    return 0;
}