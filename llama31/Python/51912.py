import math\n\ndef calculate_packets_needed(payload_size):\n    # Approximate number of possible payloads\n    possible_payloads = 2 ** payload_size\n    \n    # Calculate the number of packets needed using the birthday problem formula\n    packets_needed = math.sqrt(2 * possible_payloads * math.log(2))\n    \n    return packets_needed\n\npayload_size = 12000  # 1500 bytes \* 8 bits/byte\npackets_needed = calculate_packets_needed(payload_size)\n\nprint("Approximate number of packets needed to find two packets with the same payload:", packets_needed)