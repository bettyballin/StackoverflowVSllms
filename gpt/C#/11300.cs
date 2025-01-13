using System;\nusing System.Drawing;\nusing System.Drawing.Imaging;\n\npublic class LowBitDepthImage\n{\n    public static void Main()\n    {\n        // Create a new Bitmap with a specific pixel format (e.g., 8bppIndexed)\n        int width = 100;\n        int height = 100;\n        Bitmap bitmap = new Bitmap(width, height, PixelFormat.Format8bppIndexed);\n\n        // Fill the bitmap with some graphics (for demonstration purposes)\n        using (Graphics g = Graphics.FromImage(bitmap))\n        {\n            g.Clear(Color.Red);\n        }\n\n        // Save the bitmap to a file\n        string filePath = "low_bit_depth_image.png";\n        bitmap.Save(filePath, ImageFormat.Png);\n\n        // Dispose the bitmap\n        bitmap.Dispose();\n\n        Console.WriteLine($"Image saved to {filePath}");\n    }\n}