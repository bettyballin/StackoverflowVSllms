from twisted.internet import reactor, protocol\n\nimport pickle\n\nclass Echo(protocol.Protocol):\n\n    def connectionMade(self):\n        self.factory.clients.append(self)\n\n    def connectionLost(self, reason):\n        self.factory.clients.remove(self)\n\n    def dataReceived(self, data):\n        try:\n            obj = pickle.loads(data)\n            print(obj)\n        except (pickle.UnpicklingError, EOFError):\n            print("Received:", data[:20])  # Print first 20 bytes of received data\n\ndef main():\n    factory = protocol.Factory()\n    factory.protocol = Echo\n    factory.clients = []\n    reactor.listenTCP(8000, factory)\n    reactor.run()\n\nif __name__ == '__main__':\n    main()