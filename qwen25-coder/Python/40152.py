from smtplib import SMTP\nfrom email.mime.text import MIMEText\nfrom email.mime.multipart import MIMEMultipart\n\n# Example of storing emails in a string\nto_addresses = "email1@example.com,  email2@example.com, email3@example.com"\n\n# Clean and split the email addresses properly\ncleaned_emails = [email.strip() for email in to_addresses.split(',')]\nrecipients = ", ".join(cleaned_emails)\n\n# Setup MIME\nmessage = MIMEMultipart()\nmessage['From'] = 'your-email@example.com'\nmessage['To'] = recipients\nmessage['Subject'] = 'Your Subject Here'\nbody = 'This is the body of the email.'\nmessage.attach(MIMEText(body, 'plain'))\n\n# Create SMTP session for sending the mail\nwith SMTP('smtp.example.com', 587) as session:\n    session.starttls()  # Enable security\n    session.login('your-email@example.com', 'your-password')  # Login with mail_id and password\n    text = message.as_string()\n    session.sendmail('your-email@example.com', cleaned_emails, text)