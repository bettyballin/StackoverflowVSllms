from twilio.rest import Client\n\n# Your Account SID and Auth Token from twilio.com/console\naccount_sid = 'your_account_sid'\nauth_token = 'your_auth_token'\nclient = Client(account_sid, auth_token)\n\nmessage = client.messages.create(\n    body="Hello from Twilio!",\n    from_='+1234567890',  # Your Twilio number\n    to='+0987654321'     # Recipient's number\n)\n\nprint(message.sid)