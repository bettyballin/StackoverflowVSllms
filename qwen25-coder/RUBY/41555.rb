require 'gserver'\n\nclass SimpleServer < GServer\n  def serve(io)\n    loop do\n      line = io.readline.chomp rescue break # Read until newline or EOF\n      puts "Received: #{line}"\n    end\n  end\nend\n\nSimpleServer.new(port, ipaddr).start.joi