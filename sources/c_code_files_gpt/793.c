#include <pcap.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <pcap file>\n", argv[0]);
        return 1;
    }

    char errbuf[PCAP_ERRBUF_SIZE];
    pcap_t *handle = pcap_open_offline(argv[1], errbuf);
    if (handle == NULL) {
        fprintf(stderr, "Error opening pcap file: %s\n", errbuf);
        return 1;
    }

    struct pcap_pkthdr header;
    const u_char *data;
    int packet_count = 0;

    // Loop through packets in the pcap file
    while ((data = pcap_next(handle, &header)) != NULL) {
        packet_count++;
    }

    printf("Total number of packets: %d\n", packet_count);

    pcap_close(handle);
    return 0;
}