import smtplib\n\n# Connect to Gmail's secure SMTP server on port 587\nserver = smtplib.SMTP('smtp.gmail.com', 587)\nserver.ehlo()          # Can be omitted\nserver.starttls()      # Secure the connection using TLS\nserver.ehlo()          # Can be omitted\n\n# Log in to your email account\nserver.login("your_email@gmail.com", "your_password")\n\n# Send an email\nmessage = "Subject: Hello\n\nThis is a test message from Python."\nserver.sendmail("from_email@gmail.com", "to_email@gmail.com", message)\n\n# Disconnect\nserver.quit()