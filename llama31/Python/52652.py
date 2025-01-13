import pyshark\n\n# Set up the capture\ncapture = pyshark.LiveCapture(interface='eth0', bpf_filter='http')\n\n# Run the capture\nfor packet in capture:\n    # Check if the packet is an HTTP GET request for an XML file\n    if packet.http.request_uri.endswith('.xml'):\n        print(packet.http.request_uri)\n        break