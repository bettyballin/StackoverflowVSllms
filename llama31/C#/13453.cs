using PdfSharp.Pdf;\nusing System.IO;\n\n// create a new PDF document\nPdfDocument document = new PdfDocument();\n\n// ... add pages and content to the document ...\n\n// save the PDF to a MemoryStream\nMemoryStream ms = new MemoryStream();\ndocument.Save(ms);\n\n// prepend the PDF header to the MemoryStream\nms.Position = 0;\nbyte[] pdfHeader = { 0x25, 0x50, 0x44, 0x46, 0x2d, 0x31, 0x2e, 0x34 }; // %PDF-1.4\nms.Write(pdfHeader, 0, pdfHeader.Length);\nms.Position = 0;\n\n// now the MemoryStream contains a valid PDF