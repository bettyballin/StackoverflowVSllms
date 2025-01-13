import ipaddress\n\ndef ipv6_to_bigints(ipv6_addr):\n    ipv6_obj = ipaddress.IPv6Address(ipv6_addr)\n    return (int(ipv6_obj) >> 64, int(ipv6_obj) & 0xFFFFFFFFFFFFFFFF)\n\n# Example usage\nipv6_addr = '2001:0db8:85a3:0000:0000:8a2e:0370:7334'\nhigh, low = ipv6_to_bigints(ipv6_addr)\nprint(high, low)