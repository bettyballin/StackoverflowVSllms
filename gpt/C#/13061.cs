using System;\n\nclass ColorTransition\n{\n    static void Main()\n    {\n        const int totalHours = 240;\n        const int steps = totalHours;\n\n        // Starting color (Bright Green)\n        byte startR = 0x00;\n        byte startG = 0xFF;\n        byte startB = 0x00;\n\n        // Ending color (Dark Red)\n        byte endR = 0xFF;\n        byte endG = 0x00;\n        byte endB = 0x00;\n\n        for (int step = 0; step <= steps; step++)\n        {\n            double t = (double)step / steps;\n\n            byte currentR = (byte)(startR + (endR - startR) * t);\n            byte currentG = (byte)(startG + (endG - startG) * t);\n            byte currentB = (byte)(startB + (endB - startB) * t);\n\n            string hexColor = $"#{currentR:X2}{currentG:X2}{currentB:X2}";\n            Console.WriteLine($"Hour {step}: {hexColor}");\n        }\n    }\n}