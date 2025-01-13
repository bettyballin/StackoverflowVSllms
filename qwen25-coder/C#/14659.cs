using System;\nusing System.IO;\nusing iText.Kernel.Pdf;\nusing iText.Kernel.Pdf.Canvas.Parser;\n\npublic class PdfParser\n{\n    public static string ExtractTextFromPdf(string pdfPath)\n    {\n        using (PdfReader reader = new PdfReader(pdfPath))\n        using (PdfDocument pdfDoc = new PdfDocument(reader))\n        {\n            StringBuilder sb = new StringBuilder();\n            \n            for (int i = 1; i <= pdfDoc.GetNumberOfPages(); i++)\n            {\n                ITextExtractionStrategy strategy = new SimpleTextExtractionStrategy();\n                string currentText = PdfTextExtractor.GetTextFromPage(pdfDoc.GetPage(i), strategy);\n                sb.Append(currentText);\n            }\n\n            return sb.ToString();\n        }\n    }\n}