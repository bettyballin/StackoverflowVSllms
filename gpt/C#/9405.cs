using System;\n    using System.IO;\n    using RazorEngine;\n    using RazorEngine.Templating; // For extension methods.\n\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            // Define the path to the template file\n            string templatePath = "path/to/your/template.cshtml";\n            \n            // Load the template content\n            string templateContent = File.ReadAllText(templatePath);\n            \n            // Create an instance of your data model\n            var customData = new CustomData\n            {\n                Title = "Hello, World!",\n                Content = "This is a sample content."\n            };\n            \n            // Generate the HTML from the template and data\n            string resultHtml = Engine.Razor.RunCompile(templateContent, "templateKey", typeof(CustomData), customData);\n            \n            // Define the path to save the generated HTML file\n            string htmlPath = "path/to/save/generated.html";\n            \n            // Write the generated HTML to a file\n            File.WriteAllText(htmlPath, resultHtml);\n            \n            Console.WriteLine("HTML generated successfully!");\n        }\n    }