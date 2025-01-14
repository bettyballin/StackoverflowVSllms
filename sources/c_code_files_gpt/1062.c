#include <stdio.h>
#include <stdlib.h>
#include <pcap.h>

int main()
{
    pcap_t *pcap;
    char pcapErr[PCAP_ERRBUF_SIZE];
    struct pcap_pkthdr *pktHeader;
    const u_char *pktData;

    pcap = pcap_open_offline("somefile.pcap", pcapErr);
    if (pcap == NULL)
    {
        fprintf(stderr, "pcap_open_offline failed: %s\n", pcapErr);
        exit(EXIT_FAILURE);
    }

    while (pcap_next_ex(pcap, &pktHeader, &pktData) == 1)
    {
        // do things here
    }

    pcap_close(pcap);

    return EXIT_SUCCESS;
}