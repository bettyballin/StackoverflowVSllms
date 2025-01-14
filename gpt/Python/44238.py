from twilio.rest import Client\n\n# Your Account SID and Auth Token from twilio.com/console\naccount_sid = 'your_account_sid'\nauth_token = 'your_auth_token'\n\n# Initialize the client\nclient = Client(account_sid, auth_token)\n\n# Send SMS message\nmessage = client.messages.create(\n    body='Hello, this is a test message from your service!',\n    from_='+1234567890', # Your Twilio number\n    to='+0987654321' # Recipient's phone number\n)\n\nprint(f"Message sent with SID: {message.sid}")