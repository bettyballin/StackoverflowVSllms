import socket\n\n# Server\nwith socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:\n    s.bind(('localhost', 12345))\n    s.listen()\n    conn, addr = s.accept()\n    with conn:\n        print('Connected by', addr)\n        while True:\n            data = conn.recv(1024)\n            if not data: break\n            conn.sendall(data)\n\n# Client\nwith socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:\n    s.connect(('localhost', 12345))\n    s.sendall(b'Hello, world')\n    data = s.recv(1024)\n\nprint('Received', repr(data))