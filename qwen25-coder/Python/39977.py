import ipaddress\n\n# Example usage with a string representation\nipv6_address_with_prefix = '2001:db8::/32'\nnetwork = ipaddress.ip_network(ipv6_address_with_prefix, strict=False)\n\n# Extract the network prefix\nprefix = str(network.network_address) + '/' + str(network.prefixlen)\nprint(prefix)  # Output: 2001:db8::/32\n\n# If you only have an address and a separate prefix length:\nipv6_address_only = '2001:db8::'\nprefix_length = 32\nnetwork_from_parts = ipaddress.ip_network(f"{ipv6_address_only}/{prefix_length}", strict=False)\n\n# Extract the network prefix\nprefix_from_parts = str(network_from_parts.network_address) + '/' + str(network_from_parts.prefixlen)\nprint(prefix_from_parts)  # Output: 2001:db8::/32