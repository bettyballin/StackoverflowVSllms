# windows_server.py\nimport socket\nfrom ctypes import *\n\n# Load your DLL\nmy_dll = CDLL('path_to_your.dll')\n\n# Setup TCP connection\nHOST = '127.0.0.1'  # Localhost for testing\nPORT = 65432\n\nwith socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:\n    s.bind((HOST, PORT))\n    s.listen()\n    print("Listening on port", PORT)\n    \n    conn, addr = s.accept()\n    with conn:\n        print('Connected by', addr)\n        while True:\n            data = conn.recv(1024)\n            if not data:\n                break\n            # Call DLL function based on received command\n            response = my_dll.SomeFunction(data.decode())\n            conn.sendall(str(response).encode())