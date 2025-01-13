import socket\n\n# Create a TCP/IP socket\nsock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n\n# Server address and port\nserver_address = ('localhost', 10000)\n\n# Connect the socket to the server\nsock.connect(server_address)\n\ntry:\n    # Send the message\n    message = b'This is a message.'\n    print(f'Sending: {message}')\n    sock.sendall(message)\n\n    # Receive response (if any)\n    data = sock.recv(4096)\n    print(f'Received: {data}')\n\nfinally:\n    print('Closing socket')\n    sock.close()