import smtplib\nfrom email.mime.text import MIMEText\nfrom email.header import Header\nimport datetime\nimport os\n\n# Use environment variables for security\nusername = os.getenv("SMTP_USERNAME")\npassword = os.getenv("SMTP_PASSWORD")\n\nsmtp_server = 'YOUR.MAIL.SERVER'\nport = 587  # Commonly used port for TLS\n\ntry:\n    # Connect to the SMTP server using TLS\n    smtp = smtplib.SMTP(smtp_server, port)\n    smtp.starttls()  # Secure the connection\n    smtp.login(username, password)\n\n    from_addr = "John Doe <john@doe.net>"\n    to_addr = "foo@bar.com"\n\n    subj = "hello"\n    date = datetime.datetime.now().strftime("%d/%m/%Y %H:%M")\n\n    message_text = "Hello\nThis is a mail from your server\n\nBye\n"\n    msg = MIMEText(message_text)\n\n    msg['Subject'] = Header(subj)\n    msg['From'] = Headers(from_addr)\n    msg['To'] = Header(to_addr)\n    msg['Date'] = date\n\n    smtp.sendmail(from_addr, to_addr, msg.as_string())\nfinally:\n    smtp.quit()