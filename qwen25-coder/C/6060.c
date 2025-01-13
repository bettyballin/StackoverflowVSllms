#include <pcap.h>\n#include <stdio.h>\n\nvoid packet_handler(u_char *param, const struct pcap_pkthdr* header, const u_char* pkt_data)\n{\n    printf("Packet received!\n");\n    // Packet processing logic here...\n}\n\nint main()\n{\n    char errbuf[PCAP_ERRBUF_SIZE];\n    pcap_t* descr = pcap_open_live("", BUFSIZ, 1/*promisc*/, 200, errbuf);\n    if(descr==NULL) {\n        printf("pcap_open_live() failed: %s\n",errbuf);\n        return -1;\n    }\n\n    // Set the filter to capture only relevant traffic (e.g., TCP packets)\n    struct bpf_program fp;       /* compiled filter program (expression) */\n    char filter_exp[] = "tcp";\n    bpf_u_int32 mask;            /* subnet mask */\n    bpf_u_int32 net;             /* IP */\n\n    // Compile and apply the filter\n    if(pcap_compile(descr, &fp, filter_exp, 0, net)==-1) {\n        fprintf(stderr,"Couldn't parse filter %s: %s\n",filter_exp, pcap_geterr(descr));\n        return(2);\n    }\n    if(pcap_setfilter(descr,&fp)!=0) {\n        fprintf(stderr,"Couldn't install filter %s: %s\n", filter_exp, pc_geterr(descr));\n        return(2);\n    }\n\n    // Start capturing packets\n    pcap_loop(descr, 10/*number of packets*/, packet_handler, NULL);\n\n    pcap_close(descr);\n    return(0);\n}