import socket\nimport struct\n\n# Define the SSH1 protocol constants\nSSH1_PROTO_VERSION = '1.5'\nSSH1_MSG_DISCONNECT = 1\n\ndef connect(host, port, username, password):\n    # Establish a socket connection\n    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n    sock.connect((host, port))\n\n    # Send the SSH1 protocol version\n    sock.sendall(f'SSH-{SSH1_PROTO_VERSION}-{username}\r\n'.encode())\n\n    # Receive the server's protocol version\n    server_version = sock.recv(1024).decode()\n\n    # Send the authentication request\n    auth_request = struct.pack('>IB', 1, len(password)) + password.encode()\n    sock.sendall(auth_request)\n\n    # Receive the server's response\n    response = sock.recv(1024)\n    if response[0] != SSH1_MSG_DISCONNECT:\n        print('Authentication successful!')\n    else:\n        print('Authentication failed!')\n\n# Example usage:\nconnect('example.com', 22, 'username', 'password')