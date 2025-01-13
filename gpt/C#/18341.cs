using System;\nusing System.IO;\nusing iText.Kernel.Pdf;\nusing iText.Kernel.Pdf.Canvas.Parser;\nusing OfficeOpenXml;\n\nnamespace PdfToExcel\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            string pdfPath = "path/to/your/document.pdf";\n            string excelPath = "path/to/your/output.xlsx";\n\n            var pdfText = ExtractTextFromPdf(pdfPath);\n            ExportTextToExcel(pdfText, excelPath);\n\n            Console.WriteLine("PDF data extracted and exported to Excel successfully!");\n        }\n\n        static string ExtractTextFromPdf(string pdfPath)\n        {\n            using (PdfReader pdfReader = new PdfReader(pdfPath))\n            using (PdfDocument pdfDocument = new PdfDocument(pdfReader))\n            {\n                var strategy = new SimpleTextExtractionStrategy();\n                var pdfText = PdfTextExtractor.GetTextFromPage(pdfDocument.GetPage(1), strategy);\n                return pdfText;\n            }\n        }\n\n        static void ExportTextToExcel(string text, string excelPath)\n        {\n            using (ExcelPackage excelPackage = new ExcelPackage())\n            {\n                var worksheet = excelPackage.Workbook.Worksheets.Add("Sheet1");\n                string[] lines = text.Split('\n');\n\n                for (int i = 0; i < lines.Length; i++)\n                {\n                    worksheet.Cells[i + 1, 1].Value = lines[i];\n                }\n\n                FileInfo fileInfo = new FileInfo(excelPath);\n                excelPackage.SaveAs(fileInfo);\n            }\n        }\n    }\n}