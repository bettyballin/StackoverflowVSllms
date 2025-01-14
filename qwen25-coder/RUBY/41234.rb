require 'socket'\n\nserver_ip = "127.0.0.1"\nport = 1234\nfilename_to_send = ARGV[0] || abort("Usage: ruby file_client.rb filename")\n\nFile.open(filename_to_send, "rb") do |file|\n  client = TCPSocket.new(server_ip, port)\n  client.puts(File.basename(filename_to_send)) # send the filename to the server\n\n  while data = file.read(1024) # read in chunks of 1024 bytes\n    break if data.size == 0\n    client.write(data) # write data to the socket\n  end\n\n  response = client.gets.chomp\n  puts(response)\nensure\n  client.close\nend