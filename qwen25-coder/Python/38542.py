from scapy.all import sniff\n\ndef analyze_packet(packet):\n    if packet.haslayer('TCP'):\n        payload = bytes(packet['Raw'].load)\n        # Store or compare the payload as needed\n        print(f"Captured Payload: {payload}")\n\n# Sniff packets on a specific interface, adjust filter as necessary\nsniff(iface="eth0", filter="tcp", prn=analyze_packet, count=10)