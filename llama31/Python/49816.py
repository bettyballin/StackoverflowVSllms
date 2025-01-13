from twisted.internet import reactor, protocol\nfrom twisted.python import log\n\nclass ICQClient(protocol.Protocol):\n    def connectionMade(self):\n        log.msg('Connected to ICQ server')\n        self.transport.write(b'Hello, ICQ!')\n\n    def dataReceived(self, data):\n        log.msg('Received data from ICQ server:', data)\n\nclass ICQClientFactory(protocol.ClientFactory):\n    protocol = ICQClient\n\n    def clientConnectionFailed(self, connector, reason):\n        log.msg('Connection to ICQ server failed:', reason)\n\n    def clientConnectionLost(self, connector, reason):\n        log.msg('Connection to ICQ server lost:', reason)\n\nreactor.connectTCP('login.icq.com', 5190, ICQClientFactory())\nreactor.run()