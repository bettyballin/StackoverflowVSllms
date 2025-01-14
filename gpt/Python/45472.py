import socket\nimport threading\n\n# Function to handle client connections\ndef handle_client(client_socket):\n    while True:\n        message = client_socket.recv(1024)\n        if not message:\n            break\n        print(f"Received: {message.decode('utf-8')}")\n        client_socket.send("Acknowledged".encode('utf-8'))\n    client_socket.close()\n\n# Set up server\ndef start_server():\n    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n    server.bind(('0.0.0.0', 9999))\n    server.listen(5)\n    print("Server listening on port 9999")\n    while True:\n        client_socket, addr = server.accept()\n        print(f"Accepted connection from {addr}")\n        client_handler = threading.Thread(target=handle_client, args=(client_socket,))\n        client_handler.start()\n\n# Set up client\ndef start_client():\n    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n    client.connect(('127.0.0.1', 9999))\n    client.send("Hello Server".encode('utf-8'))\n    response = client.recv(4096)\n    print(f"Received: {response.decode('utf-8')}")\n    client.close()\n\n# Start the server in a separate thread\nserver_thread = threading.Thread(target=start_server)\nserver_thread.start()\n\n# Start multiple clients for testing\nfor i in range(5):\n    client_thread = threading.Thread(target=start_client)\n    client_thread.start()