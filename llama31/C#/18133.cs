Bitmap img = new Bitmap(width, height, PixelFormat.Format16bppGrayScale);\nRectangle rect = new Rectangle(0, 0, width, height);\nBitmapData picData = img.LockBits(rect, ImageLockMode.WriteOnly, PixelFormat.Format16bppGrayScale);\n\nMarshal.Copy(dataArray, 0, picData.Scan0, dataArray.Length);\n\nimg.UnlockBits(picData);\n\nusing (var stream = new FileStream(path, FileMode.Create))\n{\n    img.Save(stream, ImageFormat.Jpeg);\n}