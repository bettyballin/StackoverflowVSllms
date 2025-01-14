import requests\nimport smtplib\nfrom email.message import EmailMessage\nimport time\n\n# Configuration\nSITE_URL = "http://your-moss-2007-test-site-url/"\nCHECK_INTERVAL = 300  # Check every 5 minutes (in seconds)\nEMAIL_ADDRESS = "your-email@example.com"\nEMAIL_PASSWORD = "your-email-password"\nSMTP_SERVER = "smtp.example.com"\nSMTP_PORT = 587\nRECIPIENT_EMAIL = "admin@example.com"\n\ndef send_email(subject, body):\n    msg = EmailMessage()\n    msg.set_content(body)\n    msg['Subject'] = subject\n    msg['From'] = EMAIL_ADDRESS\n    msg['To'] = RECIPIENT_EMAIL\n\n    with smtplib.SMTP(SMTP_SERVER, SMTP_PORT) as server:\n        server.starttls()\n        server.login(EMAIL_ADDRESS, EMAIL_PASSWORD)\n        server.send_message(msg)\n\ndef check_site():\n    try:\n        response = requests.get(SITE_URL)\n        if response.status_code == 200:\n            print("Site is up!")\n        else:\n            send_email(f"Alert: Site {SITE_URL} is down", f"Status code received: {response.status_code}")\n    except requests.exceptions.RequestException as e:\n        send_email(f"Alert: Cannot reach site {SITE_URL}", str(e))\n\nif __name__ == "__main__":\n    while True:\n        check_site()\n        time.sleep(CHECK_INTERVAL)