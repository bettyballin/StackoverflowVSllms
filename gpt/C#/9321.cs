using System;\nusing System.IO;\nusing iTextSharp.text.pdf;\nusing iTextSharp.text.pdf.parser;\n\npublic class PdfParser\n{\n    public static string ExtractTextFromPdf(string path)\n    {\n        if (!File.Exists(path))\n            throw new FileNotFoundException("The file was not found.", path);\n\n        using (var reader = new PdfReader(path))\n        {\n            var text = new StringWriter();\n            for (int i = 1; i <= reader.NumberOfPages; i++)\n            {\n                text.WriteLine(PdfTextExtractor.GetTextFromPage(reader, i));\n            }\n            return text.ToString();\n        }\n    }\n}\n\n// Usage Example\npublic class Program\n{\n    public static void Main()\n    {\n        string pdfPath = @"path\to\your\pdf\file.pdf";\n        string extractedText = PdfParser.ExtractTextFromPdf(pdfPath);\n        Console.WriteLine(extractedText);\n    }\n}