using System;\nusing System.Drawing;\nusing System.Drawing.Imaging;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string imagePath = "path_to_your_image.jpg";\n\n        using (Image image = Image.FromFile(imagePath))\n        {\n            // Retrieve the horizontal and vertical resolution in DPI.\n            float xDpi = image.HorizontalResolution;\n            float yDpi = image.VerticalResolution;\n\n            Console.WriteLine($"Horizontal Resolution: {xDpi} DPI");\n            Console.WriteLine($"Vertical Resolution: {yDpi} DPI");\n\n            // Optionally, you can also get dimensions\n            int width = image.Width;\n            int height = image.Height;\n\n            Console.WriteLine($"Width: {width} pixels");\n            Console.WriteLine($"Height: {height} pixels");\n        }\n    }\n}