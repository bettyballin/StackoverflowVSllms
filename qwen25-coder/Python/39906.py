from scapy.all import Ether, sendp\n\n# Create an Ethernet frame\neth = Ether(src="00:11:22:33:44:55", dst="66:77:88:99:aa:bb")\n\n# Send the Ethernet frame on interface 'eth0'\nsendp(eth, iface='eth0')