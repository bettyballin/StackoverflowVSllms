# Drop 20% of all incoming TCP packets on port 80\nsudo iptables -A INPUT -p tcp --dport 80 -m statistic --mode random --probability 0.20 -j DROP