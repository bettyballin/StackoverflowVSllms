using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        bool isRedirectedOut = Console.IsOutputRedirected;\n        bool isRedirectedError = Console.IsErrorRedirected;\n\n        if (isRedirectedOut)\n        {\n            // Further check to see if it's redirected to a file\n            var outStream = Console.OpenStandardOutput();\n            var errorStream = Console.OpenStandardError();\n\n            bool isFileRedirectionOut = IsFileStream(outStream);\n            bool isFileRedirectionError = IsFileStream(errorStream);\n\n            if (isFileRedirectionOut)\n            {\n                // Output is redirected to a file\n                Console.WriteLine("Console.Out is redirected and it's a file.");\n            }\n            else\n            {\n                // Possible pipe or other redirection\n                Console.WriteLine("Console.Out is redirected but not necessarily to a file.");\n            }\n\n            if (isFileRedirectionError)\n            {\n                // Error output is redirected to a file\n                Console.WriteLine("Console.Error is redirected and it's a file.");\n            }\n            else\n            {\n                // Possible pipe or other redirection\n                Console.WriteLine("Console.Error is redirected but not necessarily to a file.");\n            }\n        }\n    }\n\n    static bool IsFileStream(Stream stream)\n    {\n        return stream is FileStream;\n    }\n}