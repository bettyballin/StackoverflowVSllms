public static void SaveImageAsPng(string sourcePath, string destinationPath)\n{\n    var image = new Bitmap(sourcePath);\n\n    // Optionally remove metadata for PNGs \n    if (image.PropertyItems.Length > 0)\n        foreach (PropertyItem prop in image.PropertyItems)\n            image.RemovePropertyItem(prop.Id);\n\n    // Save as PNG\n    image.Save(destinationPath, ImageFormat.Png);\n}