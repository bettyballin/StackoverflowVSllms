using System;\nusing System.Net.Mail;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        try\n        {\n            MailMessage message = new MailMessage();\n            message.From = new MailAddress("tad@myconsoleapp.com");\n            message.To.Add(new MailAddress("terry.donaghe@gmail.com"));\n            message.Subject = "This is my subject";\n            message.Body = "This is the content";\n\n            SmtpClient client = new SmtpClient("localhost");\n            client.Port = 25; // Ensure this matches the port your SMTP server is listening on\n            client.Send(message);\n\n            Console.WriteLine("Email sent successfully.");\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"An error occurred: {ex.Message}");\n        }\n\n        Console.ReadLine();\n    }\n}