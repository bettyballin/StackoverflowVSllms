import requests\nimport smtplib\nfrom email.mime.text import MIMEText\n\n# Configuration\nurl = 'https://your-web-service.com'\ncheck_interval = 300  # in seconds\nemail_sender = 'your-email@example.com'\nemail_receiver = 'alert-email@example.com'\nsmtp_server = 'smtp.example.com'\nsmtp_port = 587\nsmtp_user = 'your-email@example.com'\nsmtp_password = 'your-email-password'\n\ndef send_alert(message):\n    msg = MIMEText(message)\n    msg['Subject'] = 'Web Service Down Alert'\n    msg['From'] = email_sender\n    msg['To'] = email_receiver\n\n    with smtplib.SMTP(smtp_server, smtp_port) as server:\n        server.starttls()\n        server.login(smtp_user, smtp_password)\n        server.sendmail(email_sender, [email_receiver], msg.as_string())\n\ndef check_service():\n    try:\n        response = requests.get(url, timeout=10)\n        if response.status_code != 200:\n            send_alert(f'Service returned status code: {response.status_code}')\n    except requests.exceptions.RequestException as e:\n        send_alert(f'Error connecting to the service: {e}')\n\nif __name__ == '__main__':\n    import time\n    while True:\n        check_service()\n        time.sleep(check_interval)