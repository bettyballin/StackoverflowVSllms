import imaplib\n\nsess = imaplib.IMAP4()\nsess.login('superuser', 'password')\n# Honor the mailbox syntax of your server!\nsess.select('INBOX/Luke') # Or something similar. \ntyp, data = sess.search(None, 'ALL') # All Messages.\n\nsubjectlines = []\nfor num in data[0].split():\n    typ, msgdata = sess.fetch(num, '(RFC822.SIZE BODY[HEADER.FIELDS (SUBJECT)])')\n    subject = msgdata[0][1].lstrip('Subject: ').strip()\n    subjectlines.append(subject)