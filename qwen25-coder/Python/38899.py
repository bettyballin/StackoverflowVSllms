import smtplib\nfrom ssl import create_default_context\n\n# Create a secure SSL context\ncontext = create_default_context()\n\ntry:\n    with smtplib.SMTP_SSL("smtp.example.com", 465, context=context) as server:\n        server.login("user@example.com", "password")\n        server.sendmail(\n            "from@example.com",\n            ["to@example.com"],\n            """\\nSubject: Hi there\n\nThis message is sent from Python."""\n        )\nexcept Exception as e:\n    print(f"Failed to send email: {e}")