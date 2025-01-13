using (var br = new BinaryReader(File.Open(strPath, FileMode.Open)))\n{\n    var buffer = new byte[1024];\n    var line = new StringBuilder();\n    while (br.Read(buffer, 0, buffer.Length) > 0)\n    {\n        foreach (var b in buffer)\n        {\n            if (b == 0x0A) // LF\n            {\n                var lineStr = line.ToString();\n                if (!string.IsNullOrWhiteSpace(lineStr))\n                {\n                    InsertData(lineStr);\n                }\n                line.Clear();\n            }\n            else\n            {\n                line.Append((char)b);\n            }\n        }\n    }\n    // Process the last line\n    var lastLine = line.ToString();\n    if (!string.IsNullOrWhiteSpace(lastLine))\n    {\n        InsertData(lastLine);\n    }\n}