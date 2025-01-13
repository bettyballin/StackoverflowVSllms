using System.IO;\n\npublic bool ArePathsSameFile(string path1, string path2)\n{\n    FileInfo fileInfo1 = new FileInfo(path1);\n    FileInfo fileInfo2 = new FileInfo(path2);\n\n    return fileInfo1.FullName == fileInfo2.FullName;\n}