from twisted.internet.protocol import Protocol, Factory\nfrom twisted.internet import reactor\n\nclass LengthPrefixedProtocol(Protocol):\n    def __init__(self):\n        self.buffer = b""\n        self.packet_length = None\n\n    def dataReceived(self, data):\n        self.buffer += data\n        while True:\n            if self.packet_length is None:\n                if len(self.buffer) >= 4:\n                    self.packet_length = int.from_bytes(self.buffer[:4], byteorder='big')\n                    self.buffer = self.buffer[4:]\n                else:\n                    break\n\n            if self.packet_length is not None:\n                if len(self.buffer) >= self.packet_length:\n                    packet = self.buffer[:self.packet_length]\n                    self.buffer = self.buffer[self.packet_length:]\n                    self.packet_length = None\n                    self.processPacket(packet)\n                else:\n                    break\n\n    def processPacket(self, packet):\n        # Process the complete packet here\n        print(f"Received packet: {packet}")\n\nclass LengthPrefixedFactory(Factory):\n    def buildProtocol(self, addr):\n        return LengthPrefixedProtocol()\n\nreactor.listenTCP(8000, LengthPrefixedFactory())\nreactor.run()