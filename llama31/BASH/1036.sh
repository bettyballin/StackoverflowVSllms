telnet smtp.gmail.com 587\nEHLO mydomain.com\nAUTH PLAIN <base64-encoded-username-and-password>\nMAIL FROM: <your-email-address>\nRCPT TO: <recipient-email-address>\nDATA\nSubject: Test email\nHello, this is a test email.\n.\nQUIT