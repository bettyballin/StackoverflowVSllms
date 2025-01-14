import socket\n\n# Create a UDP socket\nsock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)\n\nserver_address = ('localhost', 10000)\nmessage = b'This is the message. It will be repeated.'\n\ntry:\n    # Send data\n    print(f'Sending "{message}"')\n    sent = sock.sendto(message, server_address)\n\nfinally:\n    print('Closing socket')\n    sock.close()