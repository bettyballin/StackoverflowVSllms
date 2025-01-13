import pdfminer\nfrom reportlab.pdfgen import canvas\nfrom reportlab.lib.pagesizes import letter\n\n# Extract text from PDF\nwith open('input.pdf', 'rb') as f:\n    text = pdfminer.extract_text(f)\n\n# Reformat text to narrower column width\nlines = text.splitlines()\nreformatted_text = []\nfor line in lines:\n    words = line.split()\n    reformatted_line = ''\n    for word in words:\n        if len(reformatted_line) + len(word) + 1 > 60:  # adjust column width\n            reformatted_text.append(reformatted_line)\n            reformatted_line = word\n        else:\n            reformatted_line += ' ' + word\n    reformatted_text.append(reformatted_line)\n\n# Generate new PDF with reformatted text\nc = canvas.Canvas('output.pdf', pagesize=letter)\nc.setFont('Helvetica', 12)\nfor line in reformatted_text:\n    c.drawString(100, 750, line)  # adjust x, y coordinates\n    c.showPage()\nc.save()