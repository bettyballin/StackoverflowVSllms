import pickle\nimport socket\nimport threading\n\n# Here's our thread:\nclass ConnectionThread(threading.Thread):\n\n    def run(self):\n        # Connect to the server:\n        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)\n        client.connect(('localhost', 2727))\n\n        # Retrieve and unpickle the list object:\n        print(pickle.loads(client.recv(1024)))\n\n        # Send some messages:\n        for x in range(10):\n            message = 'Hey. ' + str(x) + '\n'\n            client.send(message.encode())\n            response = client.recv(1024)\n            print(response.decode())\n\n        # Keep the connection alive\n        while True:\n            try:\n                message = input("Enter message to send (type 'exit' to close): ")\n                if message.lower() == 'exit':\n                    break\n                client.send(message.encode())\n                response = client.recv(1024)\n                print(response.decode())\n            except:\n                break\n\n        # Close the connection\n        client.close()\n\n# Let's spawn a few threads:\nfor x in range(5):\n    ConnectionThread().start()