tcp_client = TCPSocket.new(ipaddr, port)\ntcp_client.puts('Z')  # -> GServer receives "Z\n"