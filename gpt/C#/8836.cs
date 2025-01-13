using System;\nusing System.Net;\nusing System.Net.Mail;\n\nclass Program\n{\n    static void Main()\n    {\n        try\n        {\n            // Create a new MailMessage object\n            MailMessage mail = new MailMessage();\n            \n            // Set the sender's address\n            mail.From = new MailAddress("your-email@example.com");\n            \n            // Add BCC recipients\n            mail.Bcc.Add("bcc-recipient1@example.com");\n            mail.Bcc.Add("bcc-recipient2@example.com");\n            \n            // Set the subject and body\n            mail.Subject = "Test Email with BCC only";\n            mail.Body = "This is a test email sent using only BCC addresses.";\n            \n            // Set up the SMTP client\n            SmtpClient smtpClient = new SmtpClient("smtp.example.com");\n            smtpClient.Port = 587; // Use the appropriate port for your SMTP server\n            smtpClient.Credentials = new NetworkCredential("your-email@example.com", "your-email-password");\n            smtpClient.EnableSsl = true; // Enable SSL if required by your SMTP server\n            \n            // Send the email\n            smtpClient.Send(mail);\n            \n            Console.WriteLine("Email sent successfully.");\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Exception caught in CreateTestMessage2(): {0}", ex.ToString());\n        }\n    }\n}