# Allow incoming HTTPS traffic\niptables -A INPUT -p tcp --dport 443 -j ACCEPT\n\n# Allow incoming SSH traffic for maintenance\niptables -A INPUT -p tcp --dport 22 -j ACCEPT\n\n# Drop all other incoming traffic\niptables -A INPUT -j DROP