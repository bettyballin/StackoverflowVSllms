using System;\nusing System.Threading.Tasks;\nusing SendGrid;\nusing SendGrid.Helpers.Mail;\n\npublic class EmailSender\n{\n    private const string ApiKey = "YOUR_SENDGRID_API_KEY";\n\n    public static async Task SendEmailAsync(string toEmail, string subject, string plainTextContent, string htmlContent)\n    {\n        var client = new SendGridClient(ApiKey);\n        var from = new EmailAddress("your-email@example.com", "Your Name");\n        var to = new EmailAddress(toEmail);\n        var msg = MailHelper.CreateSingleEmail(from, to, subject, plainTextContent, htmlContent);\n\n        var response = await client.SendEmailAsync(msg);\n        Console.WriteLine(response.StatusCode);\n    }\n\n    public static void Main(string[] args)\n    {\n        string toEmail = "recipient@example.com";\n        string subject = "Test Email";\n        string plainTextContent = "This is a test email with plain text content.";\n        string htmlContent = "<strong>This is a test email with HTML content.</strong>";\n\n        SendEmailAsync(toEmail, subject, plainTextContent, htmlContent).Wait();\n    }\n}