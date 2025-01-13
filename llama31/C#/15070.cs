using System.Drawing;\nusing System.Drawing.Imaging;\nusing System.IO;\n\npublic class ImageMerger\n{\n    public void MergeImages(string backgroundImagePath, string textImagePath, string outputPath)\n    {\n        using (var backgroundImage = new Bitmap(backgroundImagePath))\n        {\n            using (var textImage = new Bitmap(textImagePath))\n            {\n                using (var outputImage = new Bitmap(backgroundImage.Width, backgroundImage.Height))\n                {\n                    using (var graphics = Graphics.FromImage(outputImage))\n                    {\n                        graphics.DrawImage(backgroundImage, 0, 0);\n\n                        // Make white background of text image transparent\n                        float[][] colorMatrixElements = {\n                            new float[] {1,  0,  0,  0, 0},\n                            new float[] {0,  1,  0,  0, 0},\n                            new float[] {0,  0,  1,  0, 0},\n                            new float[] {0,  0,  0,  0, 0},\n                            new float[] {0,  0,  0,  0, 1}\n                        };\n\n                        ColorMatrix colorMatrix = new ColorMatrix(colorMatrixElements);\n                        ImageAttributes imageAttributes = new ImageAttributes();\n                        imageAttributes.SetColorMatrix(colorMatrix, ColorMatrixFlag.Default, ColorAdjustType.Bitmap);\n\n                        graphics.DrawImage(textImage, new Rectangle(0, 0, textImage.Width, textImage.Height), 0, 0, textImage.Width, textImage.Height, GraphicsUnit.Pixel, imageAttributes);\n                    }\n\n                    outputImage.Save(outputPath, ImageFormat.Jpeg);\n                }\n            }\n        }\n    }\n}