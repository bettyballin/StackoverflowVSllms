import socket\nimport struct\nimport time\n\ndef create_socket():\n    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n    s.setsockopt(socket.SOL_SOCKET, socket.SO_KEEPALIVE, 1)\n    s.setsockopt(socket.IPPROTO_TCP, socket.TCP_KEEPIDLE, 1)\n    s.setsockopt(socket.IPPROTO_TCP, socket.TCP_KEEPINTVL, 1)\n    s.setsockopt(socket.IPPROTO_TCP, socket.TCP_KEEPCNT, 3)\n    return s\n\ndef is_alive(s):\n    try:\n        # Send a zero-length message to see if the connection is still alive\n        s.send(b'')\n        return True\n    except socket.error:\n        return False\n\ndef connect_and_monitor(host, port):\n    s = create_socket()\n    try:\n        s.connect((host, port))\n        print(f"Connected to {host}:{port}")\n    except socket.error as e:\n        print(f"Could not connect to {host}:{port}: {e}")\n        return\n\n    while True:\n        if not is_alive(s):\n            print(f"Connection to {host}:{port} lost")\n            break\n        print(f"Connection to {host}:{port} is alive")\n        time.sleep(1)  # Adjust the sleep interval as needed\n\nif __name__ == "__main__":\n    host = 'example.com'  # Replace with the remote host\n    port = 80  # Replace with the remote port\n    connect_and_monitor(host, port)