from twilio.rest import Client\n\n     account_sid = 'your_account_sid'\n     auth_token = 'your_auth_token'\n     client = Client(account_sid, auth_token)\n\n     message = client.messages.create(\n                          body='Hello, this is a test message',\n                          from_='+1234567890',\n                          to='+0987654321'\n                      )\n\n     print(message.sid)