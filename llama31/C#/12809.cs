using System;\n\nclass MemoryTest\n{\n    static void Main()\n    {\n        try\n        {\n            // Try to allocate 8 TB of memory\n            byte[] buffer = new byte[8L * 1024L * 1024L * 1024L * 1024L];\n            Console.WriteLine("Memory allocated successfully!");\n        }\n        catch (OutOfMemoryException)\n        {\n            Console.WriteLine("Out of memory!");\n        }\n    }\n}