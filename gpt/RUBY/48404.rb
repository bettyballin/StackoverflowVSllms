require 'webrick'\n\nclass MyServlet < WEBrick::HTTPServlet::AbstractServlet\n  def do_GET(req, res)\n    client_ip = req.remote_ip\n    if client_ip == "127.0.0.1" || client_ip == "::1"\n      puts "Access granted for #{client_ip}"\n      res.body = "Hello, localhost!"\n    else\n      puts "Security alert, accessing through #{client_ip}"\n      res.status = 403\n      res.body = "Access forbidden"\n    end\n  end\nend\n\nserver = WEBrick::HTTPServer.new(:Port => 3344)\nserver.mount "/", MyServlet\n\ntrap("INT") { server.shutdown }\nserver.start