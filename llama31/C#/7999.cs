public static void Main(string[] args)\n{\n    foreach (string argString in args)\n    {\n        string path = System.IO.Path.GetDirectoryName(argString);\n        string filenameOnly = System.IO.Path.GetFileName(argString);\n\n        if (string.IsNullOrEmpty(path))\n        {\n            path = ".";\n        }\n\n        string[] fileList = System.IO.Directory.GetFiles(path, filenameOnly);\n\n        foreach (string fileName in fileList)\n        {\n            // Do things for each file\n        }\n    }\n}