import smtplib\n\nsmtpuser = "your_username"\nsmtppass = "your_password"\n\nsession = smtplib.SMTP("smtp-auth.ourhosting.com", 587)\n\n# Issue the STARTTLS command to switch to secure mode\nsession.ehlo()  # can be omitted in some cases, try with/without it\nsession.starttls()\nsession.ehlo()\n\n# Manually send AUTH LOGIN commands\nsession.docmd("AUTH LOGIN")\nsession.docmd(base64.b64encode(smtpuser) + '\r\n')\nsession.docmd(base64.b64encode(smtppass) + '\r\n')\n\n# Send mail as usual\nsession.sendmail(from_addr, to_addrs, msg)\nsession.quit()