Dim mailman As Object\nSet mailman = CreateObject("Chilkat_9_5_0.MailMan")\n\n' Set the SMTP server properties\nmailman.SmtpHost = "smtp.example.com"\nmailman.SmtpPort = 587\nmailman.SmtpUsername = "your_username"\nmailman.SmtpPassword = "your_password"\n\n' Create a new email object\nDim email As Object\nSet email = CreateObject("Chilkat_9_5_0.Email")\n\nemail.Subject = "Test Email"\nemail.Body = "This is a test email."\nemail.From = "your_email@example.com"\nemail.AddTo "Recipient Name", "recipient@example.com"\n\n' Send the email\nDim success As Boolean\nsuccess = mailman.SendEmail(email)\n\nIf success Then\n    MsgBox "Email sent successfully!"\nElse\n    MsgBox "Failed to send email: " & mailman.LastErrorText\nEnd If