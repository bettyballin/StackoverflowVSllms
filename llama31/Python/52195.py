import smtpd\nimport asyncore\n\nclass CustomSMTPServer(smtpd.SMTPServer):\n    def handle_VRFY(self, arg):\n        # Handle VRFY command\n        print 'VRFY:', arg\n        self.push('252 Cannot VRFY user, but will accept message and attempt delivery')\n\n    def handle_AUTH(self, arg):\n        # Handle AUTH command\n        print 'AUTH:', arg\n        # Implement your AUTH logic here\n        self.push('235 Authentication successful')\n\n    def process_message(self, peer, mailfrom, rcpttos, data):\n        print 'Receiving message from:', peer\n        print 'Message addressed from:', mailfrom\n        print 'Message addressed to  :', rcpttos\n        print 'Message length        :', len(data)\n        print 'HERE WE ARE MAN!'\n        return\n\nserver = CustomSMTPServer(('127.0.0.1', 1025), None)\nasyncore.loop()