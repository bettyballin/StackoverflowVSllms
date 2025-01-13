using System;\nusing System.IO;\nusing iText.Kernel.Pdf;\nusing iText.Kernel.Pdf.Canvas.Parser;\n\nclass Program\n{\n    static void Main()\n    {\n        string pdfPath = "example.pdf";\n        using (PdfReader reader = new PdfReader(pdfPath))\n        {\n            using (PdfDocument document = new PdfDocument(reader))\n            {\n                for (int i = 1; i <= document.GetNumberOfPages(); i++)\n                {\n                    PdfPage page = document.GetPage(i);\n                    string text = PdfTextExtractor.GetTextFromPage(page);\n                    Console.WriteLine($"Text from page {i}:\n{text}");\n                }\n            }\n        }\n    }\n}