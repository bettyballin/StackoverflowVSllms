$inputFile = 'input.pdf';\n$escapedInputFile = escapeshellarg($inputFile);\nexec("pdfimages -j $escapedInputFile output");