using System;\nusing System.Net.Http;\n\nclass Program\n{\n    static async Task Main(string[] args)\n    {\n        using (HttpClient client = new HttpClient())\n        {\n            var response = await client.GetStringAsync("https://api.example.com/data");\n            \n            if (!string.IsNullOrEmpty(response))\n            {\n                Console.WriteLine("Received data:");\n                Console.WriteLine(response);\n                \n                // Example string manipulation\n                string transformedData = TransformString(response);\n                Console.WriteLine("Transformed data:");\n                Console.WriteLine(transformedData);\n            }\n        }\n    }\n\n    static string TransformString(string input)\n    {\n        return input.ToUpper();\n    }\n}