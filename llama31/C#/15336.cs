using System.Drawing;\nusing System.Drawing.Imaging;\n\npublic class ImageCropper\n{\n    public static Bitmap CropImage(Bitmap image)\n    {\n        int left = image.Width;\n        int right = 0;\n        int top = image.Height;\n        int bottom = 0;\n\n        for (int x = 0; x < image.Width; x++)\n        {\n            for (int y = 0; y < image.Height; y++)\n            {\n                Color pixel = image.GetPixel(x, y);\n                if (pixel.R != 255 || pixel.G != 255 || pixel.B != 255)\n                {\n                    left = Math.Min(left, x);\n                    right = Math.Max(right, x);\n                    top = Math.Min(top, y);\n                    bottom = Math.Max(bottom, y);\n                }\n            }\n        }\n\n        return image.Clone(new Rectangle(left, top, right - left + 1, bottom - top + 1), image.PixelFormat);\n    }\n}