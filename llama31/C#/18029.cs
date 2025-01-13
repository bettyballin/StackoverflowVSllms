PdfReader reader1 = new PdfReader("pdf1.pdf");\nPdfReader reader2 = new PdfReader("pdf2.pdf");\n\nRectangle pageSize1 = reader1.GetPageSize(1);\nRectangle pageSize2 = reader2.GetPageSize(1);\n\n// Calculate the margin differences\nfloat marginLeftDiff = pageSize1.Left - pageSize2.Left;\nfloat marginTopDiff = pageSize1.Top - pageSize2.Top;\n\n// Adjust your coordinates accordingly\nfloat x = 100f + marginLeftDiff;\nfloat y = 100f + marginTopDiff;\n\n// Add text to the PDFs using the adjusted coordinates