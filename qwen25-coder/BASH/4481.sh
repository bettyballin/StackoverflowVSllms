# To simulate a dropped connection for TCP packets to a specific IP and port\nsudo iptables -A OUTPUT -p tcp --dport your_port_number --dst your_server_ip -j DROP\n\n# Remove the rule after testing\nsudo iptables -D OUTPUT 1