# Define the public IP addresses\nuci set network.wan.ipaddr='x.x.x.123'\nuci set network.wan.netmask='255.255.255.0'\nuci set network.wan.gateway='x.x.x.1'\n\n# Define the NAT rules\nuci set firewall.@rule[0].src='wan'\nuci set firewall.@rule[0].dst='lan'\nuci set firewall.@rule[0].proto='tcp'\nuci set firewall.@rule[0].dport='21'\nuci set firewall.@rule[0].target='DNAT'\nuci set firewall.@rule[0].to_dst='192.168.1.100'\n\n# Define additional NAT rules for other ports and IP addresses