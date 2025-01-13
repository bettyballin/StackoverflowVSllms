import socket\nimport threading\n\ndef send_data(sock, data):\n    sock.sendall(data)\n\ndef main():\n    num_connections = 5\n    data_size = 1000000  # 1 MB\n\n    # Create multiple sockets\n    socks = []\n    for _ in range(num_connections):\n        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n        sock.connect(("example.com", 80))  # Replace with your server\n        socks.append(sock)\n\n    # Send data in parallel\n    threads = []\n    for sock in socks:\n        thread = threading.Thread(target=send_data, args=(sock, data_size * b"0"))\n        thread.start()\n        threads.append(thread)\n\n    # Wait for all threads to finish\n    for thread in threads:\n        thread.join()\n\nif __name__ == "__main__":\n    main()