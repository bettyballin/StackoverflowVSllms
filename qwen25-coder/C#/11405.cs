using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        byte[] data = { 72, 101, 108, 108, 111 }; // Example byte array for "Hello"\n        \n        var writer = new StreamWriter(Application.StartupPath + @"\B323.txt");\n        string hexContent = BitConverter.ToString(data).Replace("-", ""); // Convert to hex\n        writer.Write(hexContent);\n        writer.Close();\n        writer.Dispose();\n    }\n}