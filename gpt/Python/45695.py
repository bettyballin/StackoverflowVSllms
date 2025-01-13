from PyPDF2 import PdfFileWriter, PdfFileReader\nfrom reportlab.pdfgen import canvas\nfrom reportlab.lib.pagesizes import letter\n\n# Create a new PDF using ReportLab\npacket = io.BytesIO()\ncan = canvas.Canvas(packet, pagesize=letter)\ncan.drawString(100, 750, "This is a new PDF created with ReportLab.")\ncan.save()\n\n# Move to the beginning of the StringIO buffer\npacket.seek(0)\n\n# Read the new PDF\nnew_pdf = PdfFileReader(packet)\n\n# Read the existing PDF\nexisting_pdf = PdfFileReader(open("existing_document.pdf", "rb"))\n\n# Create a PDF writer object\noutput = PdfFileWriter()\n\n# Add pages from the existing PDF\nfor page_num in range(existing_pdf.getNumPages()):\n    page = existing_pdf.getPage(page_num)\n    output.addPage(page)\n\n# Add the new page created with ReportLab\noutput.addPage(new_pdf.getPage(0))\n\n# Write the output PDF to a file\nwith open("output_document.pdf", "wb") as outputStream:\n    output.write(outputStream)