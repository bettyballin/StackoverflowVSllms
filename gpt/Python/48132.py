import smtplib\nfrom email.mime.text import MIMEText\n\n# Example email sending function\ndef send_email(subject, body, to_emails, from_email, smtp_server, smtp_port, login, password):\n    # Ensure 'to_emails' is a string with properly formatted email addresses\n    to_emails = ", ".join(to_emails.split())\n\n    # Create the email message\n    msg = MIMEText(body)\n    msg['Subject'] = subject\n    msg['From'] = from_email\n    msg['To'] = to_emails\n\n    # Send the email\n    with smtplib.SMTP(smtp_server, smtp_port) as server:\n        server.starttls()\n        server.login(login, password)\n        server.sendmail(from_email, to_emails.split(", "), msg.as_string())\n\n# Usage example\nsend_email(\n    "Subject here", \n    "Body of the email", \n    "recipient1@example.com recipient2@example.com", \n    "your_email@example.com", \n    "smtp.example.com", \n    587, \n    "your_email@example.com", \n    "your_password"\n)