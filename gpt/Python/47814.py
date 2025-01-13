import socket\n\ndef start_server():\n    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n    server_socket.bind(('0.0.0.0', 65432))\n    server_socket.listen(5)\n    print("Server started, waiting for connections...")\n\n    while True:\n        client_socket, addr = server_socket.accept()\n        print(f"Connection from {addr}")\n        \n        data = client_socket.recv(1024).decode('utf-8')\n        print(f"Received: {data}")\n        \n        # Process the data and send a response\n        response = f"Processed: {data}"\n        client_socket.send(response.encode('utf-8'))\n        \n        client_socket.close()\n\nif __name__ == "__main__":\n    start_server()