// Example of sending emails in batches\nusing System.Net.Mail;\n\npublic void SendEmailsInBatches(List<string> recipients, string subject, string body)\n{\n    var smtpClient = new SmtpClient("your.smtp.server")\n    {\n        Port = 587,\n        Credentials = new System.Net.NetworkCredential("username", "password"),\n        EnableSsl = true,\n    };\n\n    int batchSize = 100;\n    for (int i = 0; i < recipients.Count; i += batchSize)\n    {\n        using (var mailMessage = new MailMessage())\n        {\n            mailMessage.From = new MailAddress("from@example.com");\n            foreach (string recipient in recipients.Skip(i).Take(batchSize))\n            {\n                mailMessage.To.Add(recipient);\n            }\n            mailMessage.Subject = subject;\n            mailMessage.Body = body;\n            mailMessage.IsBodyHtml = true;\n\n            smtpClient.Send(mailMessage);\n        }\n\n        // Sleep for a while to avoid hitting spam filters\n        System.Threading.Thread.Sleep(500);\n    }\n}