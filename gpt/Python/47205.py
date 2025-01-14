import fitz\n   import os\n\n   def search_and_replace_text_in_pdf(file_path, search_text, replace_text):\n       # Open the PDF file\n       pdf_document = fitz.open(file_path)\n       \n       for page_number in range(len(pdf_document)):\n           page = pdf_document.load_page(page_number)\n           text_instances = page.search_for(search_text)\n           \n           for inst in text_instances:\n               # Replace the text\n               page.insert_text(inst[:2], replace_text, fontsize=12)\n       \n       # Save the modified PDF to a new file\n       new_file_path = file_path.replace(".pdf", "_modified.pdf")\n       pdf_document.save(new_file_path)\n       pdf_document.close()\n       print(f"Modified file saved as: {new_file_path}")\n\n   def process_multiple_pdfs(directory, search_text, replace_text):\n       # Iterate over all files in the directory\n       for filename in os.listdir(directory):\n           if filename.endswith(".pdf"):\n               file_path = os.path.join(directory, filename)\n               search_and_replace_text_in_pdf(file_path, search_text, replace_text)\n\n   # Directory containing PDF files\n   directory_path = "/path/to/pdf/files"\n   search_text = "http://example.com"\n   replace_text = ""\n\n   # Process all PDF files in the directory\n   process_multiple_pdfs(directory_path, search_text, replace_text)