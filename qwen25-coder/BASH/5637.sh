# Flush existing rules and chains\niptables -F\n\n# Set default policies (DROP all incoming and forward traffic, ALLOW outgoing)\niptables -P INPUT DROP\niptables -P FORWARD DROP\niptables -P OUTPUT ACCEPT\n\n# Allow established connections to continue\niptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT\n\n# Allow specific outbound HTTP traffic\niptables -A OUTPUT -p tcp --dport 80 -d 192.0.2.1 -j ACCEPT # Replace with the IP of trusted service\niptables -A OUTPUT -p tcp --dport 80 -d 203.0.113.5 -j ACCEPT # Add as many trusted IPs as needed\n\n# Drop all other outgoing connections on port 80\niptables -A OUTPUT -p tcp --dport 80 -j DROP