using System.IO;\n   using iText.Kernel.Pdf;\n   using iText.Layout;\n\n   public void CreatePdf(string dest)\n   {\n       // Initialize PDF writer\n       PdfWriter writer = new PdfWriter(dest);\n\n       // Initialize PDF document\n       PdfDocument pdf = new PdfDocument(writer);\n\n       // Initialize document\n       Document document = new Document(pdf);\n\n       // Add a paragraph to the document\n       document.Add(new Paragraph("Hello World!"));\n\n       // Close document\n       document.Close();\n   }