private void CopyFile(string inFilename, string outFilename)\n{\n    using (var inFile = new FileStream(inFilename, FileMode.Open, FileAccess.Read))\n    using (var outFile = new FileStream(outFilename, FileMode.Create, FileAccess.Write))\n    {\n        const int bufferSize = 4096; // 4KB buffer\n        var buffer = new byte[bufferSize];\n\n        while (true)\n        {\n            var bytesRead = inFile.Read(buffer, 0, bufferSize);\n            if (bytesRead == 0)\n                break;\n\n            outFile.Write(buffer, 0, bytesRead);\n\n            UpdateProgressBar();\n            Application.DoEvents();\n        }\n    }\n}