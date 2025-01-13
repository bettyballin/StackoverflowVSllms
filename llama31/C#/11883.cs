using System;\nusing Renci.SshNet;\n\nclass SftpExample\n{\n    static void Main(string[] args)\n    {\n        using (var sftpClient = new SftpClient("sftp.example.com", 22, "username", "password"))\n        {\n            sftpClient.Connect();\n\n            // Upload a file\n            using (var fileStream = new FileStream("localfile.txt", FileMode.Open))\n            {\n                sftpClient.UploadFile(fileStream, "/remote/path/file.txt");\n            }\n\n            // Download a file\n            using (var fileStream = new FileStream("localfile.txt", FileMode.Create))\n            {\n                sftpClient.DownloadFile("/remote/path/file.txt", fileStream);\n            }\n\n            sftpClient.Disconnect();\n        }\n    }\n}