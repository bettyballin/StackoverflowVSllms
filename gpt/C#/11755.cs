using System;\nusing System.Security.Cryptography.X509Certificates;\nusing MimeKit;\nusing MimeKit.Cryptography;\nusing MailKit.Net.Smtp;\nusing MailKit.Security;\n\npublic class EmailSender\n{\n    public static void SendSignedEmail()\n    {\n        var message = new MimeMessage();\n        message.From.Add(new MailboxAddress("Your Name", "you@example.com"));\n        message.To.Add(new MailboxAddress("Recipient Name", "recipient@example.com"));\n        message.Subject = "Signed Email Test";\n\n        var body = new TextPart("plain")\n        {\n            Text = @"This is a signed email."\n        };\n\n        var signedBody = new MultipartSigned();\n\n        // Load your certificate from the certificate store\n        var store = new X509Store(StoreName.My, StoreLocation.CurrentUser);\n        store.Open(OpenFlags.ReadOnly);\n        var certificates = store.Certificates.Find(X509FindType.FindBySubjectName, "Your Name", false);\n        var certificate = certificates[0];\n\n        var signer = new CmsSigner(certificate);\n        signedBody.Add(body, signer);\n\n        message.Body = signedBody;\n\n        using (var client = new SmtpClient())\n        {\n            client.Connect("smtp.example.com", 587, SecureSocketOptions.StartTls);\n            client.Authenticate("your-username", "your-password");\n            client.Send(message);\n            client.Disconnect(true);\n        }\n    }\n}