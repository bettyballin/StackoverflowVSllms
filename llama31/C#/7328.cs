using Aspose.Pdf;\n\n// Merge PDFs\nPdf pdf1 = new Pdf("file1.pdf");\nPdf pdf2 = new Pdf("file2.pdf");\nPdf mergedPdf = new Pdf();\nmergedPdf.AddPage(pdf1.Pages[1]);\nmergedPdf.AddPage(pdf2.Pages[1]);\nmergedPdf.Save("output.pdf");