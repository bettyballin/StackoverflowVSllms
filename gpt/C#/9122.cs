protected void Page_Load(object sender, EventArgs e)\n{\n    string domain = "YOUR_DOMAIN";\n    string username = "YOUR_USERNAME";\n    string password = "YOUR_PASSWORD";\n    string filePath = @"\\NetworkDrive\path\to\file.txt";\n\n    ImpersonationHelper.ReadFileAsUser(domain, username, password, filePath);\n}