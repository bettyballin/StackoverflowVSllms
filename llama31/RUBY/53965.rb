require 'socket'\n\n# create a new socket\nsock = TCPSocket.new('localhost', 8080)\n\n# your XML message\nmsg = "<your_xml_message_here>"\n\n# send the XML message followed by a null character\nsock.puts msg + "\x00"\n\n# close the socket\nsock.close