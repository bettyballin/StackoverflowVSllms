import socket\n\n# Create a UDP client socket\nclient_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)\n\n# Define the server address and port\nserver_address = ('localhost', 12345)\n\n# Send data to the server\nmessage = b'Hello, UDP Server!'\nclient_socket.sendto(message, server_address)\n\n# Receive a response from the server\nresponse, server = client_socket.recvfrom(4096)\nprint(f'Received from server: {response.decode()}')\n\n# Close the socket\nclient_socket.close()