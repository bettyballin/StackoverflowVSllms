import smtpd\nimport asyncore\nfrom smtpd import SMTPServer\nfrom smtplib import SMTPRecipientsRefused\n\nclass MailProcessorServer(SMTPServer):\n    def process_message(self, peer, sender, rcpttos, data):\n        bad_recipients = []\n        for rcpt in rcpttos:\n            if not self.is_valid_recipient(rcpt):\n                bad_recipients.append(rcpt)\n        \n        if bad_recipients:\n            raise SMTPRecipientsRefused({rcpt: '550 Recipient address rejected: User unknown in local recipient table' for rcpt in bad_recipients})\n        else:\n            # Process the message if all recipients are valid\n            print("Message accepted for: ", rcpttos)\n            # Add your message processing logic here\n            return\n\n    def is_valid_recipient(self, recipient):\n        # Implement your own validation logic here\n        # For example, check against a list of valid recipients\n        valid_recipients = ['valid@example.com']\n        return recipient in valid_recipients\n\nif __name__ == "__main__":\n    server = MailProcessorServer(('127.0.0.1', 1025), None)\n    asyncore.loop()