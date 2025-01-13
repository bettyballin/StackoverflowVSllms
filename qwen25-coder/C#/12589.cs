SmtpClient smtp;\n\nif (!string.IsNullOrEmpty(Util.get_setting("SmtpServer", "")))\n{\n    smtp = new SmtpClient(Util.get_setting("SmtpServer", ""));\n}\nelse\n{\n    smtp = new SmtpClient();\n}\n\nif (!string.IsNullOrEmpty(Util.get_setting("SmtpServerAuthenticatePassword", "")))\n    smtp.Credentials = new System.Net.NetworkCredential(\n        Util.get_setting("SmtpServerAuthenticateUser", ""), \n        Util.get_setting("SmtpServerAuthenticatePassword", ""));\n\nif (!string.IsNullOrEmpty(Util.get_setting("SmtpServerPort", "")))\n    smtp.Port = int.Parse(Util.get_setting("SmtpServerPort", ""));\n\nif (Util.get_setting("SmtpUseSSL", "0") == "1")\n    smtp.EnableSsl = true;\n\nsmtp.Send(message);