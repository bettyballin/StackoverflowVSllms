using System.Net.Mail;\n\n// ...\n\nMailMessage mail = new MailMessage();\nmail.To.Add("your_fogbugz_email@example.com");\nmail.Subject = "Error Report";\nmail.Body = "Exception details: " + exception.ToString();\n\nSmtpClient smtpClient = new SmtpClient("your_smtp_server");\nsmtpClient.Port = 587; // or your SMTP server's port\nsmtpClient.EnableSsl = true; // use SSL/TLS for encryption\nsmtpClient.Credentials = new NetworkCredential("your_smtp_username", "your_smtp_password");\n\ntry\n{\n    smtpClient.Send(mail);\n}\ncatch (SmtpException ex)\n{\n    // handle SMTP exceptions\n}