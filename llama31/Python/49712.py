import imaplib\nimport email\nimport requests\n\n# Connect to IMAP server\nmail = imaplib.IMAP4_SSL('imap.example.com')\nmail.login('username', 'password')\nmail.select('inbox')\n\n# Listen for new emails using IDLE\nmail.send("%s IDLE\r\n" % mail._new_tag())\nresponse = mail.readline()\n\nwhile True:\n    line = mail.readline()\n    if line == '':\n        break\n    if line.startswith('* BYE'):\n        break\n    if line.startswith('* EXISTS'):\n        # New email received, trigger action\n        email_contents = email.message_from_string(mail.fetch(1, '(RFC822)')[1])\n        requests.post('https://example.com/email-processor', data=email_contents.as_string())\n\nmail.close()\nmail.logout()