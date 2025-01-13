import ipaddress\n\n# Given IPv6 address and prefix length\nipv6_addr = "2001:0db8:85a3:0000:0000:8a2e:0370:7334"\nprefix_len = 64\n\n# Create an IPv6Address object\naddr = ipaddress.IPv6Address(ipv6_addr)\n\n# Create an IPv6Network object with the given prefix length\nnetwork = ipaddress.IPv6Network((addr, prefix_len), strict=False)\n\n# Get the prefix (i.e., the network address)\nprefix = network.network_address\n\nprint(prefix)  # Output: 2001:db8:85a3::