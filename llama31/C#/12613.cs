using System;\nusing System.Net.Mail;\n\n// Assuming 'message' is the raw email message\nMailMessage mailMessage = new MailMessage();\nmailMessage = MimeKit.MimeMessage.Load(message);\n\nforeach (MimeKit.MimeEntity attachment in mailMessage.Attachments)\n{\n    var fileSize = attachment.ContentLength;\n    // Use the file size as needed\n}