#include <stdio.h>
#include <pcap/pcap.h>

int main(int argc, char *argv[]) {
    int packet_count = 0; // Initialize a variable to keep track of packets.
    pcap_t *handle;
    const u_char *packet;
    struct pcap_pkthdr hdr;
    char errbuf[PCAP_ERRBUF_SIZE]; // Added errbuf declaration

    if (argc < 2) {
        printf("Usage: %s filename\n", argv[0]); // Added newline
        return -1;
    }

    // Open a packet capture file for reading.
    handle = pcap_open_offline(argv[1], errbuf);
    if (handle == NULL) {
        fprintf(stderr, "Couldn't open file %s: %s\n", argv[1], errbuf); // Added newline
        return -1;
    }

    // Iterate through and count each packet.
    while ((packet = pcap_next(handle, &hdr)) != NULL) {
        packet_count++;
        printf("Packet #%d\n", packet_count); // Added newline
    }

    if (packet == NULL && packet_count == 0) {
        fprintf(stderr, "No packets in file %s.\n", argv[1]); // Added newline
        return -1;
    } else {
        printf("Total number of packets: %d\n", packet_count); // Added newline
    }

    pcap_close(handle); // Added handle closure
    return 0; // Added return statement
}