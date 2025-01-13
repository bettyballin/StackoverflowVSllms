using System;\nusing System.IO;\nusing Renci.SshNet;\n\nclass Program\n{\n    static void Main()\n    {\n        string host = "sftp.example.com";\n        int port = 22;\n        string username = "your_username";\n        string password = "your_password"; // It's better to use more secure ways to handle passwords, like environment variables or secure vaults\n        string remoteFilePath = "/remote/path/to/file.txt";\n        string localFilePath = "C:\\local\\path\\to\\file.txt";\n\n        using (var sftp = new SftpClient(host, port, username, password))\n        {\n            try\n            {\n                sftp.Connect();\n                using (var fileStream = File.OpenWrite(localFilePath))\n                {\n                    sftp.DownloadFile(remoteFilePath, fileStream);\n                }\n                Console.WriteLine("File downloaded successfully.");\n            }\n            catch (Exception e)\n            {\n                Console.WriteLine("An error occurred: " + e.Message);\n            }\n            finally\n            {\n                sftp.Disconnect();\n            }\n        }\n    }\n}