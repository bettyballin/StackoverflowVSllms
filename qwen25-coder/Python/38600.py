# Example Python code snippet to parse JSON in a network packet using Scapy and json libraries\nfrom scapy.all import *\nimport json\n\ndef handle_packet(packet):\n    # Check for TCP packets containing HTTP data\n    if packet.haslayer(TCP) and packet.haslayer(Raw):\n        payload = str(packet[Raw].load)\n        try:\n            # Attempt to parse JSON data in the payload\n            data = json.loads(payload)\n            print(data)\n        except ValueError:\n            pass\n\n# Start sniffing on interface eth0\nsniff(iface='eth0', filter="tcp port 80", prn=handle_packet)