require 'twilio-ruby'\n\n# Initialize the client\naccount_sid = 'YOUR_TWILIO_ACCOUNT_SID'\nauth_token = 'YOUR_TWILIO_AUTH_TOKEN'\nclient = Twilio::REST::Client.new(account_sid, auth_token)\n\n# Send a message\nmessage = client.messages.create(\n  body: "Hello from your Rails app!",\n  from: '+1234567890', # Your Twilio number\n  to: '+0987654321'    # Recipient's phone number\n)\n\nputs message.sid