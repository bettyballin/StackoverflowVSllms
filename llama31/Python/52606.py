from scapy.all import *\n\npacket = IP(dst="example.com")/TCP(dport=80)\nresponse = sr1(packet, verbose=0)\nprint(response.show())