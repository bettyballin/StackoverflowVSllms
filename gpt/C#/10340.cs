using System.Net;\nusing System.Net.Mail;\n\nSmtpClient client = new SmtpClient("your_ess_smtp_server", 25)\n{\n    Credentials = new NetworkCredential("username", "password"),\n    EnableSsl = false,\n};\n\nMailMessage message = new MailMessage("sender@example.com", "recipient@example.com")\n{\n    Subject = "Test",\n    Body = "This is a test email."\n};\n\ntry\n{\n    client.Send(message);\n}\ncatch (Exception ex)\n{\n    Console.WriteLine("Exception caught in CreateTestMessage2(): {0}", ex.ToString());\n}