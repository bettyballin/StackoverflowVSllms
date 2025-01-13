using System;\nusing System.IO;\nusing System.Windows.Controls;\nusing iText.Kernel.Pdf;\nusing iText.Kernel.Pdf.Canvas.Parser;\n\nnamespace YourNamespace\n{\n    public partial class MainWindow : Window\n    {\n        public MainWindow()\n        {\n            InitializeComponent();\n            LoadPdfToRichTextBox("yourfile.pdf");\n        }\n\n        private void LoadPdfToRichTextBox(string filePath)\n        {\n            using (PdfDocument pdfDoc = new PdfDocument(new PdfReader(filePath)))\n            {\n                string textFromPage;\n                for (int i = 1; i <= pdfDoc.GetNumberOfPages(); i++)\n                {\n                    ITextExtractionStrategy strategy = new SimpleTextExtractionStrategy();\n                    textFromPage = PdfTextExtractor.GetTextFromPage(pdfDoc.GetPage(i), strategy);\n                    richTextBox.AppendText(textFromPage + Environment.NewLine);\n                }\n            }\n        }\n    }\n}