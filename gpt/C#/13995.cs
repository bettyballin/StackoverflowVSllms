using System.Net.Mail;\n\nMailMessage email = new MailMessage();\nemail.IsBodyHtml = true;\nemail.Body = @"\n<html>\n<head>\n<style>\nbody { font-family: Arial, sans-serif; }\n</style>\n</head>\n<body>\n<p>This is a paragraph with Arial font.</p>\n</body>\n</html>\n";