import smtplib\nfrom email.mime.text import MIMEText\n\ndef send_alert(message):\n    msg = MIMEText(message)\n    msg['Subject'] = 'Filesystem Space Anomaly Detected'\n    msg['From'] = 'alert@example.com'\n    msg['To'] = 'admin@example.com'\n    \n    s = smtplib.SMTP('localhost')\n    s.send_message(msg)\n    s.quit()\n\n# Check if there are any anomalies\nif not anomalies.empty:\n    send_alert(f"Anomalous filesystem space usage detected at {anomalies.index[-1]}")