using System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string strFileName = @"C:\MyPicture.jpeg";\n        FileStream inFile = new FileStream(strFileName, FileMode.Open, FileAccess.Read);\n        byte[] binaryData = new byte[inFile.Length];\n        long bytesRead = inFile.Read(binaryData, 0, (int)inFile.Length);\n        inFile.Close();\n    }\n}