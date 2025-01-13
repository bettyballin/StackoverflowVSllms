using System;\nusing System.IO;\nusing iTextSharp.text.pdf;\nusing iTextSharp.text.pdf.parser;\n\nclass Program\n{\n    static void Main()\n    {\n        string pdfPath = "path/to/your/document.pdf";\n        string text = ExtractTextFromPdf(pdfPath);\n        Console.WriteLine(text);\n    }\n\n    public static string ExtractTextFromPdf(string path)\n    {\n        using (PdfReader reader = new PdfReader(path))\n        {\n            StringWriter output = new StringWriter();\n            for (int i = 1; i <= reader.NumberOfPages; i++)\n            {\n                string text = PdfTextExtractor.GetTextFromPage(reader, i);\n                output.WriteLine(text);\n            }\n            return output.ToString();\n        }\n    }\n}