import smtplib\nfrom email.mime.text import MIMEText\n\ndef send_email(subject, message, from_addr, to_addrs, password):\n    # Create MIMEText object with the given parameters\n    msg = MIMEText(message)\n    msg['Subject'] = subject\n    msg['From'] = from_addr\n    msg['To'] = ', '.join(to_addrs)\n\n    try:\n        # Connect to Gmail's SMTP server\n        server = smtplib.SMTP('smtp.gmail.com:587')\n        server.ehlo()\n        server.starttls()  # Secure the connection\n        server.login(from_addr, password)  # Log in\n\n        # Send email and disconnect from the server\n        server.sendmail(from_addr, to_addrs, msg.as_string())\n        print("Email sent successfully!")\n    except Exception as e:\n        print(f"Failed to send email: {e}")\n    finally:\n        server.quit()\n\n# Example usage\nsend_email(\n    subject="Hello from Python",\n    message="This is a test email sent from a Python script.",\n    from_addr="your-email@gmail.com",\n    to_addrs=["recipient@example.com"],\n    password="your-email-password"\n)