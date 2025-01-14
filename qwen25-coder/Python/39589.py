import sctp\n\n# Create an SCTP socket\nsock = sctp.sctpsocket_tcp(socket.AF_INET)\n\n# Bind the socket to a local address\nserver_address = ('0.0.0.0', 38412)\nsock.bind(server_address)\n\n# Listen for incoming connections\nsock.listen(5)\n\nprint("Waiting for connection")\nconnection, addr = sock.accept()\n\ntry:\n    print('Connection from:', addr)\n    while True:\n        data = connection.recv(1024)\n        if not data:\n            break\n        print('Received {!r}'.format(data))\nfinally:\n    # Clean up the connection\n    connection.close()