# Allow HTTP (port 80) and HTTPS (port 443) from specific IP addresses\niptables -A INPUT -p tcp --dport 80 -s <allowed_ip> -j ACCEPT\niptables -A INPUT -p tcp --dport 443 -s <allowed_ip> -j ACCEPT\n\n# Allow FTP (port 21) from specific IP addresses\niptables -A INPUT -p tcp --dport 21 -s <allowed_ip> -j ACCEPT\n\n# Drop all other incoming traffic to these ports\niptables -A INPUT -p tcp --dport 80 -j DROP\niptables -A INPUT -p tcp --dport 443 -j DROP\niptables -A INPUT -p tcp --dport 21 -j DROP