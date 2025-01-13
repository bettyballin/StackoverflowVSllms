import pymysql\nfrom docx import Document\nimport fitz  # PyMuPDF\n\n# Function to extract text from .docx\ndef extract_text_from_docx(file_path):\n    doc = Document(file_path)\n    return ' '.join([paragraph.text for paragraph in doc.paragraphs])\n\n# Function to extract text from .pdf\ndef extract_text_from_pdf(file_path):\n    text = ""\n    doc = fitz.open(file_path)\n    for page in doc:\n        text += page.get_text()\n    return text\n\n# Store extracted text in MySQL\ndef store_text_in_mysql(file_name, text):\n    connection = pymysql.connect(host='your_host', user='your_user', password='your_password', db='your_db')\n    try:\n        with connection.cursor() as cursor:\n            sql = "INSERT INTO documents (file_name, content) VALUES (%s, %s)"\n            cursor.execute(sql, (file_name, text))\n        connection.commit()\n    finally:\n        connection.close()\n\n# Example usage\ndocx_text = extract_text_from_docx('example.docx')\npdf_text = extract_text_from_pdf('example.pdf')\n\nstore_text_in_mysql('example.docx', docx_text)\nstore_text_in_mysql('example.pdf', pdf_text)