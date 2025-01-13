using iTextSharp.text.pdf;\n\npublic int GetNumberOfPages(string pdfFile)\n{\n    PdfReader reader = new PdfReader(pdfFile);\n    int numberOfPages = reader.NumberOfPages;\n    reader.Close();\n    return numberOfPages;\n}