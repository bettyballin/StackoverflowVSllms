# Client sends packet to server\ntcpdump -i eth0 -n -vv -s 0 -c 100 -W 100 port 80\n\n# Server goes down before receiving packet\n# Client retransmits packet after RTO\ntcpdump -i eth0 -n -vv -s 0 -c 100 -W 100 port 80