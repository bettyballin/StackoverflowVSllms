using (FileStream fs = new FileStream(filePath, FileMode.Create))\n   {\n       pdfDocument.Save(fs);\n   }