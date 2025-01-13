using iTextSharp.text.pdf;\n\npublic void ReorderPdfPages(string inputFile, string outputFile, int[] newPageOrder)\n{\n    using (PdfReader pdfReader = new PdfReader(inputFile))\n    {\n        using (PdfCopy pdfCopy = new PdfCopy(Document.Open(), new FileStream(outputFile, FileMode.Create)))\n        {\n            for (int i = 0; i < newPageOrder.Length; i++)\n            {\n                pdfCopy.AddPage(pdfReader.GetPageN(newPageOrder[i]));\n            }\n        }\n    }\n}