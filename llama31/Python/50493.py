from twisted.internet import reactor, protocol\n\nclass MyProtocol(protocol.Protocol):\n    # Shared set to hold all active protocol instances\n    active_protocols = set()\n\n    def connectionMade(self):\n        # Add the protocol instance to the shared set when a connection is made\n        self.active_protocols.add(self)\n\n    def connectionLost(self, reason):\n        # Remove the protocol instance from the shared set when a connection is lost\n        self.active_protocols.remove(self)\n\n    def sendData(self, data):\n        # Method to send data to the client\n        self.transport.write(data.encode())\n\ndef send_data_to_all_protocols():\n    # Function that sends data to all connected protocols periodically\n    data = "Hello, client!"  # The data you want to send\n    for protocol in MyProtocol.active_protocols:\n        protocol.sendData(data)\n    # Schedule the next call\n    reactor.callLater(10, send_data_to_all_protocols)  # Call every 10 seconds\n\nclass MyFactory(protocol.Factory):\n    def buildProtocol(self, addr):\n        return MyProtocol()\n\n# Create the factory and listen on a port\nreactor.listenTCP(8000, MyFactory())\n\n# Start the periodic data sending\nsend_data_to_all_protocols()\n\n# Run the reactor\nreactor.run()