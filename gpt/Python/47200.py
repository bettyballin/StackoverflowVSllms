import socket\nimport threading\n\ndef send_data(host, port, data):\n    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:\n        s.connect((host, port))\n        s.sendall(data)\n        s.close()\n\nhost = 'example.com'\nport = 80\ndata = b'GET / HTTP/1.1\r\nHost: example.com\r\n\r\n'\n\n# Number of parallel connections\nnum_connections = 5\nthreads = []\n\nfor _ in range(num_connections):\n    thread = threading.Thread(target=send_data, args=(host, port, data))\n    threads.append(thread)\n    thread.start()\n\nfor thread in threads:\n    thread.join()