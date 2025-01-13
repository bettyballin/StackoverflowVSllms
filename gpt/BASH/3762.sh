# Enable IP forwarding\nsysctl -w net.ipv4.ip_forward=1\n\n# Set up iptables rules\niptables -t mangle -N DIVERT\niptables -t mangle -A PREROUTING -p tcp -m socket -j DIVERT\niptables -t mangle -A DIVERT -j MARK --set-mark 1\niptables -t mangle -A DIVERT -j ACCEPT\niptables -t mangle -A PREROUTING -p tcp -m mark --mark 1 -j TPROXY --on-port YOUR_PROXY_PORT --tproxy-mark 1