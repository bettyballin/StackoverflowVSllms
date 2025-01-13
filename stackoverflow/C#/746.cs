XpsDocument xpsDoc = new XpsDocument(xpsFileName, System.IO.FileAccess.Read);\n\nFixedDocumentSequence docSeq = xpsDoc.GetFixedDocumentSequence();\nconst double scaleFactor = 0.8;\nfor (int pageNum = 0; pageNum < docSeq.DocumentPaginator.PageCount; pageNum++)\n{\n    DocumentPage docPage = docSeq.DocumentPaginator.GetPage(pageNum);\n\n    // FIX: calling GetPage without calling UpdateLayout causes a memory leak\n    ((FixedPage)docPage.Visual).UpdateLayout();\n\n    RenderTargetBitmap renderTarget = new RenderTargetBitmap((int)Math.Round(scaleFactor * docPage.Size.Width),\n                (int)Math.Round(scaleFactor * docPage.Size.Height), (int)Math.Round(scaleFactor * 96), (int)Math.Round(scaleFactor * 96), PixelFormats.Default);\n    renderTarget.Render(docPage.Visual);\n\n    JpegBitmapEncoder encoder = new JpegBitmapEncoder();\n    encoder.QualityLevel = 75;\n    // Choose type here ie: JpegBitmapEncoder, etc\n    //BitmapEncoder encoder = new PngBitmapEncoder();  // Choose type here ie: JpegBitmapEncoder, etc\n    encoder.Frames.Add(BitmapFrame.Create(renderTarget));\n\n    string pageImageFileName = string.Format("{0}-{1}.jpg", Path.Combine(Path.GetDirectoryName(xpsFileName), Path.GetFileNameWithoutExtension(xpsFileName)), pageNum);\n            using (FileStream pageOutStream = new FileStream(pageImageFileName, FileMode.Create, FileAccess.Write))\n    {\n        encoder.Save(pageOutStream);\n    }\n}