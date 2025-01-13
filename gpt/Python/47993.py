import socket\n\n   # Client side\n   def ditp_client(server_ip, server_port):\n       with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:\n           s.connect((server_ip, server_port))\n           greeting = "HELLO"\n           first_request = "GET /resource"\n           s.sendall(f"{greeting}\n{first_request}\n".encode())\n           response = s.recv(1024)\n           print('Received', repr(response))\n\n   # Server side\n   def ditp_server(host, port):\n       with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:\n           s.bind((host, port))\n           s.listen()\n           conn, addr = s.accept()\n           with conn:\n               print('Connected by', addr)\n               data = conn.recv(1024)\n               if data:\n                   print("Received data:", data.decode())\n                   response = "ACK"\n                   conn.sendall(response.encode())