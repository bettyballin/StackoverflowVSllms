using System;\nusing System.IO;\nusing iText.Kernel.Pdf;\nusing iText.Kernel.Pdf.Canvas.Parser;\nusing ClosedXML.Excel;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Path to the PDF file.\n        string pdfPath = "input.pdf";\n        // Output Excel file path.\n        string excelPath = "output.xlsx";\n\n        // Read text from the PDF.\n        string textFromPdf = ExtractTextFromPdf(pdfPath);\n\n        // Create a new workbook and worksheet.\n        var workbook = new XLWorkbook();\n        IXLWorksheet worksheet = workbook.Worksheets.Add("PDF Data");\n\n        // Simple example: split text by lines and write to Excel.\n        int rowIndex = 1;\n        foreach (string line in textFromPdf.Split('\n'))\n        {\n            worksheet.Cell(rowIndex, 1).Value = line.Trim();\n            rowIndex++;\n        }\n\n        // Save the workbook to a file.\n        workbook.SaveAs(excelPath);\n    }\n\n    static string ExtractTextFromPdf(string filePath)\n    {\n        using (PdfReader reader = new PdfReader(filePath))\n        using (PdfDocument pdfDoc = new PdfDocument(reader))\n        {\n            StringBuilder textFromPages = new StringBuilder();\n\n            for (int page = 1; page <= pdfDoc.GetNumberOfPages(); page++)\n            {\n                ITextExtractionStrategy strategy = new SimpleTextExtractionStrategy();\n                string currentText = PdfTextExtractor.GetTextFromPage(pdfDoc, page, strategy);\n                textFromPages.Append(currentText + "\n");\n            }\n\n            return textFromPages.ToString();\n        }\n    }\n}