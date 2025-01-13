using iTextSharp.text.pdf;\n\n// Open the PDF file\nusing (var pdfReader = new PdfReader("input.pdf"))\n{\n    // Get the first page\n    var page = pdfReader.GetPageN(1);\n\n    // Add a new paragraph\n    var paragraph = new Paragraph("Hello, World!");\n    page.Add(paragraph);\n\n    // Save the modified PDF\n    using (var pdfWriter = new PdfWriter("output.pdf"))\n    {\n        pdfWriter.AddPage(page);\n    }\n}