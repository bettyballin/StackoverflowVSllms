using System.Net.Mail;\n\n// ...\n\nMailMessage mail = new MailMessage();\nmail.To.Add(new MailAddress("recipient@example.com"));\nmail.From = new MailAddress("sender@example.com");\nmail.Subject = "Test Email";\nmail.Body = "This is a test email.";\n\n// Use a secure SMTP client\nSmtpClient smtpClient = new SmtpClient();\nsmtpClient.Host = "smtp.example.com";\nsmtpClient.Port = 587;\nsmtpClient.EnableSsl = true;\nsmtpClient.Credentials = new NetworkCredential("smtp_username", "smtp_password");\n\n// Send the email\nsmtpClient.Send(mail);