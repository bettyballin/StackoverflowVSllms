def handle_read(self):\n    print("handle_read() called")\n    data = self.recv(1024)\n    print(data)