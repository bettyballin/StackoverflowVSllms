from PyPDF2 import PdfReader, PdfWriter\nfrom reportlab.pdfgen import canvas\n\ndef merge_pdfs(input_pdf_path, output_pdf_path, start_page=0):\n    # Create a PDF reader object for the input PDF\n    pdf_reader = PdfReader(open(input_pdf_path, "rb"))\n    \n    # Create a PDF writer object for the output PDF\n    pdf_writer = PdfWriter()\n    \n    # Add all pages from the existing PDF to the output (you can adjust which pages you want)\n    for page_num in range(start_page, len(pdf_reader.pages)):\n        pdf_writer.add_page(pdf_reader.pages[page_num])\n    \n    # Create a new PDF file\n    with open(output_pdf_path, "wb") as out:\n        pdf_writer.write(out)\n\n# Example usage: Merge (or include) page from existing PDF into a new one\ninput_pdf = 'existing_document.pdf'\noutput_pdf = 'new_report_with_existing_page.pdf'\n\nmerge_pdfs(input_pdf, output_pdf, start_page=0)  # Include the first page\n\n# Note: If you need to add more content using ReportLab, you can extend this script.