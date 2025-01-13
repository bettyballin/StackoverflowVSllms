#include <pcap.h>\n\nint main() {\n    pcap_t *handle;\n    char errbuf[PCAP_ERRBUF_SIZE];\n\n    handle = pcap_open_live("any", 65535, 1, 1000, errbuf);\n    if (handle == NULL) {\n        // Error handling\n    }\n\n    pcap_loop(handle, 100, packet_callback, NULL);\n\n    pcap_close(handle);\n    return 0;\n}\n\nvoid packet_callback(u_char *args, const struct pcap_pkthdr *header, const u_char *packet) {\n    // Analyze SMTP packet here\n}