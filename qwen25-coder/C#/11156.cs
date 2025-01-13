using OpenPop.Mime;\nusing System.Net.Mail;\nusing System.Text.RegularExpressions;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string popServer = "pop.yourserver.com";\n        int popPort = 110; // or 995 for SSL\n        bool useSslForPop = false;\n        string smtpServer = "smtp.yourserver.com";\n        int smtpPort = 25; // or 465/587 for SSL/TLS\n        bool useSslForSmtp = true;\n        string username = "yourusername@yoursite.com";\n        string password = "yourpassword";\n\n        using (var pop3Client = new OpenPop.Pop3.Pop3Client())\n        {\n            // Connect to the POP3 server\n            if (useSslForPop)\n                pop3Client.Connect(popServer, popPort, true);\n            else\n                pop3Client.Connect(popServer, popPort);\n\n            // Log in to the POP3 server\n            pop3Client.Authenticate(username, password);\n\n            int messageCount = pop3Client.GetMessageCount();\n            for (int i = 1; i <= messageCount; i++)\n            {\n                Message message = pop3Client.GetMessage(i);\n                string body = message.MessagePart.MessageBody.ToString();\n\n                // Custom business logic here\n                if (ShouldForward(message))\n                {\n                    MailAddress from = GetNewFromAddress();\n                    MailAddress to = new MailAddress(GetNewToAddress(body));\n\n                    using (SmtpClient smtpClient = new SmtpClient(smtpServer, smtpPort))\n                    {\n                        smtpClient.EnableSsl = useSslForSmtp;\n                        smtpClient.Credentials = new System.Net.NetworkCredential(username, password);\n\n                        var mailMessage = new MailMessage(from, to)\n                        {\n                            Subject = message.Headers.Subject,\n                            Body = body\n                        };\n\n                        smtpClient.Send(mailMessage);\n                    }\n\n                    // Optionally delete or mark the message as forwarded\n                }\n            }\n\n            pop3Client.Disconnect();\n        }\n    }\n\n    static bool ShouldForward(Message message)\n    {\n        // Implement your custom logic here\n        return true;\n    }\n\n    static MailAddress GetNewFromAddress()\n    {\n        // Define your new from address here\n        return new MailAddress("newfromaddress@yourdomain.com");\n    }\n\n    static string GetNewToAddress(string body)\n    {\n        // Example: extract the "to" address from the message body using a placeholder or logic\n        Match match = Regex.Match(body, @"Recipient:\s*([\w@\.-]+)");\n        if (match.Success)\n            return match.Groups[1].Value;\n\n        // Default to a fixed email if none found\n        return "defaultrecipient@yourdomain.com";\n    }\n}