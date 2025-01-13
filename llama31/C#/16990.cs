using MailKit.Net.Smtp;\nusing MailKit.Security;\nusing MimeKit;\n\n// Create a new email message\nvar message = new MimeMessage();\nmessage.From.Add(new MailboxAddress("Your Name", "your_email@example.com"));\nmessage.To.Add(new MailboxAddress("Customer Service Account", "customer_service@example.com"));\nmessage.Subject = "Test Email";\nmessage.Body = new TextPart("plain") { Text = "This is a test email." };\n\n// Send the email using MailKit\nusing (var client = new SmtpClient())\n{\n    client.Connect("your_smtp_server", 25, SecureSocketOptions.StartTls);\n    client.Authenticate("your_username", "your_password");\n    client.Send(message);\n    client.Disconnect(true);\n}