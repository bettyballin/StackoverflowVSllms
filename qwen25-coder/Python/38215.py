import socket\nimport threading\n\n# Define constants\nPORT = 5005\nMCAST_GRP = '239.1.1.1'\nBUFFER_SIZE = 1024\n\ndef listen_for_messages():\n    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)\n    membership = socket.inet_aton(MCAST_GRP) + socket.inet_aton('0.0.0.0')\n    mreq = struct.pack("4sL", membership, socket.INADDR_ANY)\n    sock.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, mreq)\n\n    while True:\n        data, addr = sock.recvfrom(BUFFER_SIZE)\n        print(f"Received message: {data.decode()} from {addr}")\n\ndef send_discovery_message():\n    msg_to_send = b'Hello, P2P Network!'\n    while True:\n        with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:\n            s.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, 2)\n            s.sendto(msg_to_send, (MCAST_GRP, PORT))\n        time.sleep(5)\n\nif __name__ == '__main__':\n    listener_thread = threading.Thread(target=listen_for_messages)\n    listener_thread.daemon = True\n    listener_thread.start()\n\n    send_discovery_message()