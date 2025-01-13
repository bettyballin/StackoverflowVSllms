using System.Drawing;\nusing System.Drawing.Imaging;\nusing System.IO;\n\npublic class ImageHelper\n{\n    public void SaveImageWithFileSize(string inputFilePath, string outputFilePath, int fileSizeKB)\n    {\n        // Load the image\n        using (var image = Image.FromFile(inputFilePath))\n        {\n            // Determine the output format\n            ImageFormat outputFormat = outputFilePath.EndsWith(".png", StringComparison.OrdinalIgnoreCase) \n                ? ImageFormat.Png \n                : ImageFormat.Jpeg;\n\n            // Get the file size in bytes\n            int fileSizeBytes = fileSizeKB * 1024;\n\n            // Calculate the quality parameter for JPEG or compression level for PNG\n            int quality = 100; // Default quality for JPEG\n            if (outputFormat == ImageFormat.Jpeg)\n            {\n                while (File.Exists(outputFilePath) && new FileInfo(outputFilePath).Length > fileSizeBytes)\n                {\n                    quality -= 10;\n                    using (var encoder = EncoderParametersCollection())\n                    {\n                        encoder.Param[0] = new EncoderParameter(Encoder.Quality, quality);\n                        image.Save(outputFilePath, GetEncoderInfo(outputFormat), encoder);\n                    }\n                }\n            }\n            else if (outputFormat == ImageFormat.Png)\n            {\n                int compressionLevel = 6; // Default compression level for PNG\n                while (File.Exists(outputFilePath) && new FileInfo(outputFilePath).Length > fileSizeBytes)\n                {\n                    compressionLevel++;\n                    using (var encoder = new PngEncoder())\n                    {\n                        encoder.CompressionLevel = compressionLevel;\n                        image.Save(outputFilePath, outputFormat);\n                    }\n                }\n            }\n        }\n    }\n\n    private ImageCodecInfo GetEncoderInfo(ImageFormat format)\n    {\n        return ImageCodecInfo.GetImageEncoders().FirstOrDefault(e => e.FormatID == format.Guid);\n    }\n\n    private EncoderParametersCollection EncoderParametersCollection()\n    {\n        var encoderParams = new EncoderParameters(1);\n        encoderParams.Param[0] = new EncoderParameter(Encoder.Quality, 100L);\n        return encoderParams;\n    }\n}