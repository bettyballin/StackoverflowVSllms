import pyshark\n\n   capture = pyshark.LiveCapture(interface='eth0')\n   for packet in capture.sniff_continuously(packet_count=10):\n       print(packet)