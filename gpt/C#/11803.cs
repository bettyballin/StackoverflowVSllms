using System;\nusing System.Drawing;\nusing System.Drawing.Imaging;\n\npublic class EdgeWhitespaceDetection\n{\n    public static Rectangle GetNonWhitespaceBounds(Bitmap bitmap)\n    {\n        var top = bitmap.Height;\n        var left = bitmap.Width;\n        var right = 0;\n        var bottom = 0;\n\n        BitmapData data = bitmap.LockBits(new Rectangle(0, 0, bitmap.Width, bitmap.Height), ImageLockMode.ReadOnly, PixelFormat.Format32bppArgb);\n        int stride = data.Stride;\n        IntPtr scan0 = data.Scan0;\n\n        unsafe\n        {\n            byte* p = (byte*)scan0;\n            for (int y = 0; y < bitmap.Height; y++)\n            {\n                for (int x = 0; x < bitmap.Width; x++)\n                {\n                    byte alpha = p[(y * stride) + (x * 4) + 3];\n                    byte blue = p[(y * stride) + (x * 4) + 0];\n                    byte green = p[(y * stride) + (x * 4) + 1];\n                    byte red = p[(y * stride) + (x * 4) + 2];\n\n                    if (alpha > 0 || (red != 255 || green != 255 || blue != 255))\n                    {\n                        if (y < top) top = y;\n                        if (y > bottom) bottom = y;\n                        if (x < left) left = x;\n                        if (x > right) right = x;\n                    }\n                }\n            }\n        }\n\n        bitmap.UnlockBits(data);\n\n        if (left <= right && top <= bottom)\n        {\n            return new Rectangle(left, top, right - left + 1, bottom - top + 1);\n        }\n\n        return Rectangle.Empty; // No non-white/transparent pixels found\n    }\n\n    public static Bitmap CropToContent(Bitmap bitmap)\n    {\n        Rectangle bounds = GetNonWhitespaceBounds(bitmap);\n        if (bounds == Rectangle.Empty)\n        {\n            return null; // or return a new Bitmap(1, 1)\n        }\n        \n        Bitmap croppedBitmap = new Bitmap(bounds.Width, bounds.Height, PixelFormat.Format32bppArgb);\n        using (Graphics g = Graphics.FromImage(croppedBitmap))\n        {\n            g.DrawImage(bitmap, new Rectangle(0, 0, bounds.Width, bounds.Height), bounds, GraphicsUnit.Pixel);\n        }\n        return croppedBitmap;\n    }\n}