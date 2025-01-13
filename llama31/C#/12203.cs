using System.Net;\nusing System.Net.Mail;\n\nSmtpClient smtpClient = new SmtpClient();\nsmtpClient.Host = "smtp.example.com";\nsmtpClient.Port = 587;\nsmtpClient.EnableSsl = true;\nsmtpClient.Credentials = new NetworkCredential("username", "password");\n\n// Set the HTTP proxy details\nsmtpClient.Proxy = new WebProxy("http://proxy-server:8080", true);\n\nMailMessage mailMessage = new MailMessage();\nmailMessage.From = new MailAddress("from@example.com");\nmailMessage.To.Add("to@example.com");\nmailMessage.Subject = "Test Email";\nmailMessage.Body = "This is a test email";\n\ntry\n{\n    smtpClient.Send(mailMessage);\n}\ncatch (Exception ex)\n{\n    Console.WriteLine(ex.Message);\n}