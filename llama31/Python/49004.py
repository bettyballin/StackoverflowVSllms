import PyPDF2\nimport re\n\n# Open PDF file\nwith open("example.pdf", "rb") as pdfFile:\n    # Create PDF reader\n    pdfReader = PyPDF2.PdfFileReader(pdfFile)\n\n    # Extract text from first page\n    pageText = pdfReader.getPage(0).extractText()\n\n    # Search for ISBN using regular expression\n    isbnMatch = re.search(r"\bISBN[-:]? (?P<isbn>\d{13}|\d{10})\b", pageText)\n    if isbnMatch:\n        isbn = isbnMatch.group("isbn")\n        print(f"ISBN: {isbn}")