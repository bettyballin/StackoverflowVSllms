public void AppendPdf(string srcFile, string destFile)\n{\n    string tempFile = Path.GetTempFileName();\n\n    using (PdfReader reader = new PdfReader(srcFile))\n    {\n        using (PdfReader reader2 = new PdfReader(destFile))\n        {\n            using (PdfCopy copy = new PdfCopy(new PdfDocument(), new FileStream(tempFile, FileMode.Create)))\n            {\n                copy.AddDocument(reader);\n                copy.AddDocument(reader2);\n            }\n        }\n    }\n\n    File.Replace(tempFile, srcFile, null);\n}