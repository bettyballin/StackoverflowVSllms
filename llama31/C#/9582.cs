public void ResizeImage(string imagePath, int width, int height)\n{\n    // Open the image file\n    using (Image image = Image.FromFile(imagePath))\n    {\n        // Create a new bitmap with the desired size\n        Bitmap resizedBitmap = new Bitmap(width, height);\n\n        // Create a graphics object from the bitmap\n        Graphics graphics = Graphics.FromImage(resizedBitmap);\n\n        // Draw the original image on the graphics object\n        graphics.DrawImage(image, 0, 0, width, height);\n\n        // Save the resized bitmap to the output stream\n        resizedBitmap.Save(context.Response.OutputStream, ImageFormat.Png);\n\n        // Dispose of the graphics object and bitmap\n        graphics.Dispose();\n        resizedBitmap.Dispose();\n    }\n}