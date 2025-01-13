using System;\nusing System.Net;\nusing System.Net.Mail;\n\nclass Program\n{\n    static void Main()\n    {\n        try\n        {\n            var fromAddress = new MailAddress("your-email@gmail.com", "Your Name");\n            var toAddress = new MailAddress("recipient-email@example.com", "Recipient Name");\n            const string fromPassword = "YOUR_APP_PASSWORD";\n            const string subject = "Subject of Email";\n            const string body = "Body text for email";\n\n            using (var smtp = new SmtpClient\n            {\n                Host = "smtp.gmail.com",\n                Port = 587,\n                EnableSsl = true,\n                DeliveryMethod = SmtpDeliveryMethod.Network,\n                UseDefaultCredentials = false,\n                Credentials = new NetworkCredential(fromAddress.Address, fromPassword),\n            })\n            using (var message = new MailMessage(fromAddress, toAddress)\n            {\n                Subject = subject,\n                Body = body\n            })\n            {\n                smtp.Send(message);\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Error: " + ex.Message);\n        }\n    }\n}