from django.core.mail import EmailMessage\n\ndef send_email(self, from_address, to_list, subject, msg_text, msg_html):\n    # Remove any problematic characters from the subject line.\n    subject = subject.replace('\r', '').replace('\n', ' ')\n    \n    # Initialize the email message.\n    msg = EmailMessage(\n        subject=subject,\n        body=msg_text,\n        from_email=from_address,\n        to=to_list\n    )\n    \n    # Attach the HTML as an alternative part.\n    msg.attach_alternative(msg_html, "text/html")\n    \n    # Explicitly set the MIME subtype to 'alternative'.\n    msg.mixed_subtype = 'alternative'\n    \n    # Send the email.\n    msg.send()