import pickle\nimport socket\nimport threading\n\nclass ConnectionThread(threading.Thread):\n    def run(self):\n        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n        client.connect(('localhost', 2727))\n\n        print(pickle.loads(client.recv(1024)))\n\n        for x in xrange(10):\n            client.send('Hey. ' + str(x) + '\n')\n            response = client.recv(1024)\n            print(response)\n\n        # Keep sending data\n        while True:\n            client.send('More data from client')\n            response = client.recv(1024)\n            print(response)\n\n        client.close()\n\nfor x in xrange(5):\n    ConnectionThread().start()