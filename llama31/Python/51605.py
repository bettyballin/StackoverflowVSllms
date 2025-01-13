from scapy.all import sniff, TCP, IP\n\n# Define a callback function to process each packet\ndef process_packet(packet):\n    if packet.haslayer(TCP) and packet.haslayer(IP):\n        # Extract the source and destination IP addresses\n        src_ip = packet[IP].src\n        dst_ip = packet[IP].dst\n        # Extract the TCP payload\n        payload = packet[TCP].payload\n        # Process the payload (e.g., parse it, extract fields, etc.)\n        print(f"Source IP: {src_ip}, Destination IP: {dst_ip}, Payload: {payload}")\n\n# Start sniffing packets on the default interface\nsniff(prn=process_packet, store=False)