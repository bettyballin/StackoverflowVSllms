import fitz  # PyMuPDF\nimport pytesseract\n\n# Path to the PDF file\npdf_path = "path/to/your/pdf/file.pdf"\n\n# Open the PDF file\ndocument = fitz.open(pdf_path)\n\nall_text = ""\n\nfor page_num in range(len(document)):\n    # Get a page from the document\n    page = document.load_page(page_num)\n    \n    # Convert the page to an image\n    pix = page.get_pixmap()\n    img_path = f"page_{page_num+1}.png"\n    pix.save(img_path)\n\n    # Perform OCR on the image\n    text = pytesseract.image_to_string(fitz.Pixmap(img_path).get_pixmap(), lang='eng')\n\n    # Append the recognized text to our cumulative text variable\n    all_text += text\n\n# Output or use the extracted text\nprint(all_text)