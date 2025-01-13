using Tamir.SharpSsh;\n\npublic class SftpExample\n{\n    public static void Main(string[] args)\n    {\n        string host = "your.sftp.server";\n        string username = "your_username";\n        string password = "your_password";\n        string localFile = "local_file_path";\n        string remoteFile = "remote_file_path";\n\n        Sftp sftp = new Sftp(host, username, password);\n        sftp.Connect();\n        sftp.Put(localFile, remoteFile);\n        sftp.Close();\n    }\n}