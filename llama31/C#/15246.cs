public class ImageService : IImage\n{\n    public void StoreImage(Stream imageData)\n    {\n        // Save the stream to a file or database\n        using (var fileStream = new FileStream("image.jpg", FileMode.Create))\n        {\n            imageData.CopyTo(fileStream);\n        }\n    }\n}