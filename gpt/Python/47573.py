from scapy.all import *\n   \n   packets = rdpcap('capture.pcap')\n   for packet in packets:\n       if 'specific_pattern' in str(packet):\n           print(packet.summary())