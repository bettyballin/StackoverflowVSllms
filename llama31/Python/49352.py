import PyPDF2\n\ndef extract_title(pdf_file):\n    """\n    Extract the title from a PDF file.\n\n    Args:\n        pdf_file (str): Path to the PDF file.\n\n    Returns:\n        str: The title of the PDF file.\n    """\n    with open(pdf_file, 'rb') as f:\n        pdf = PyPDF2.PdfFileReader(f)\n        info = pdf.getDocumentInfo()\n        title = info.title\n        return title\n\n# Example usage:\npdf_file = 'path/to/your/paper.pdf'\ntitle = extract_title(pdf_file)\nprint(title)