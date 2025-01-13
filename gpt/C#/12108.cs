using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string filePath = "path/to/your/file";\n        bool isBinary = IsBinaryFile(filePath);\n        Console.WriteLine(isBinary ? "The file is binary." : "The file is text.");\n    }\n\n    static bool IsBinaryFile(string filePath)\n    {\n        const int sampleSize = 1024;\n        const double threshold = 0.2; // 20% threshold\n\n        byte[] buffer = new byte[sampleSize];\n        int bytesRead;\n\n        using (FileStream fileStream = new FileStream(filePath, FileMode.Open, FileAccess.Read))\n        {\n            bytesRead = fileStream.Read(buffer, 0, sampleSize);\n        }\n\n        if (bytesRead == 0)\n        {\n            return false; // Empty file is considered text\n        }\n\n        int controlCharacterCount = 0;\n\n        for (int i = 0; i < bytesRead; i++)\n        {\n            if (buffer[i] < 32 && buffer[i] != 9 && buffer[i] != 10 && buffer[i] != 13)\n            {\n                controlCharacterCount++;\n            }\n        }\n\n        double controlCharacterRatio = (double)controlCharacterCount / bytesRead;\n        return controlCharacterRatio > threshold;\n    }\n}