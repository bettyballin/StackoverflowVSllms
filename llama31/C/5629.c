// IP Header\nstruct iphdr {\n    uint8_t  ihl:4;\n    uint8_t  version:4;\n    uint8_t  tos;\n    uint16_t tot_len;\n    uint16_t id;\n    uint16_t frag_off;\n    uint8_t  ttl;\n    uint8_t  protocol; // <--- protocol attribute\n    uint16_t check;\n    uint32_t saddr;\n    uint32_t daddr;\n};