$pdf = new PdfParser();\n$pdf->parseFile('input.pdf');\n\n// Set compression quality for images (0-100)\n$pdf->setCompressionQuality(50);\n\n$pdf->writeFile('output.pdf');