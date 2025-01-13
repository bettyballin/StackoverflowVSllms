using Aspose.Email;\nusing Aspose.Email.Mapi;\nusing System.IO;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Load the EML file\n        var mailMessage = MailMessage.Load("input.eml");\n\n        // Set up options with the desired adjustments\n        var options = SaveOptions.CreateSaveOptions(SaveFormat.Pdf);\n\n        // Save the message to PDF format\n        mailMessage.Save("output.pdf", options);\n\n        Console.WriteLine("Conversion completed successfully.");\n    }\n}