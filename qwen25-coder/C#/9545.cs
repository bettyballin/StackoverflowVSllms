using System;\nusing System.Net;\nusing System.Net.Mail;\n\nclass Program\n{\n    static void Main()\n    {\n        string From = "your-email@gmail.com";\n        string To = "recipient-email@example.com";\n        string Subject = "Test Email from C#";\n        string Body = "This is the body of the test email sent from a C# program.";\n\n        using (var client = new SmtpClient("smtp.gmail.com", 587))\n        {\n            client.EnableSsl = true;\n            client.Credentials = new NetworkCredential(From, "your-email-password");\n            \n            var message = new MailMessage\n            {\n                From = new MailAddress(From),\n                Subject = Subject,\n                Body = Body\n            };\n            message.To.Add(new MailAddress(To));\n\n            try\n            {\n                client.Send(message);\n                Console.WriteLine("Email sent successfully.");\n            }\n            catch (SmtpException ex)\n            {\n                Console.WriteLine($"Error sending email: {ex.Message}");\n            }\n        }\n    }\n}