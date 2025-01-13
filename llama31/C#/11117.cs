using System.Net.Mail;\n\npublic void SendEmail(string to, string subject, string body)\n{\n    var mail = new MailMessage();\n    mail.To.Add(to);\n    mail.Subject = subject;\n    mail.Body = body;\n\n    using (var smtpClient = new SmtpClient())\n    {\n        smtpClient.DeliveryMethod = SmtpDeliveryMethod.Network;\n        smtpClient.EnableSsl = true;\n        smtpClient.Send(mail);\n    }\n}