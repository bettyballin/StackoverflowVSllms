using System;\nusing System.Net;\nusing System.Net.Mail;\n\npublic class EmailSender\n{\n    public static void SendEmail(string toAddress, string subject, string body)\n    {\n        string fromAddress = "your-email@example.com";\n        string smtpServer = "smtp.example.com";\n        string smtpUsername = "your-smtp-username";\n        string smtpPassword = "your-smtp-password";\n\n        try\n        {\n            MailMessage mail = new MailMessage();\n            mail.From = new MailAddress(fromAddress);\n            mail.To.Add(toAddress);\n            mail.Subject = subject;\n            mail.Body = body;\n\n            SmtpClient smtpClient = new SmtpClient(smtpServer);\n            smtpClient.Port = 587; // or the port your SMTP server uses\n            smtpClient.Credentials = new NetworkCredential(smtpUsername, smtpPassword);\n            smtpClient.EnableSsl = true; // Enable SSL if required by your SMTP server\n\n            smtpClient.Send(mail);\n        }\n        catch (Exception ex)\n        {\n            // Handle exception\n            Console.WriteLine("Error sending email: " + ex.Message);\n        }\n    }\n}