require 'socket'\nrequire 'shoes'\n\nclass IRCClient\n  def initialize(server, port, nick, channel)\n    @server = server\n    @port = port\n    @nick = nick\n    @channel = channel\n  end\n\n  def connect\n    @socket = TCPSocket.open(@server, @port)\n    @socket.puts "NICK #{@nick}"\n    @socket.puts "USER #{@nick} 0 * #{@nick}"\n    @socket.puts "JOIN #{@channel}"\n  end\n\n  def send_message(message)\n    @socket.puts "PRIVMSG #{@channel} :#{message}"\n  end\n\n  def get_messages\n    loop do\n      msg = @socket.gets\n      puts msg\n    end\n  end\nend\n\nShoes.app(title: "IRC Client", width: 600, height: 400) do\n  stack do\n    @chat = edit_box width: 1.0, height: 0.8\n    @input = edit_line width: 1.0\n\n    @client = IRCClient.new('irc.freenode.net', 6667, 'YourNick', '#YourChannel')\n    @client.connect\n\n    @input.change do\n      if @input.text.end_with?("\n")\n        message = @input.text.strip\n        @client.send_message(message)\n        @chat.append("#{message}\n")\n        @input.text = ""\n      end\n    end\n\n    Thread.new do\n      @client.get_messages\n    end\n  end\nend