SmtpClient emailClient = new SmtpClient(servername);\n\n            System.Net.NetworkCredential SMTPUserInfo = new System.Net.NetworkCredential(name, pass);\n            SMTPUserInfo.Domain = domain; // i.e. "foo.com"\n            emailClient.UseDefaultCredentials = false;\n            emailClient.Credentials = SMTPUserInfo;\n            emailClient.Send(message);