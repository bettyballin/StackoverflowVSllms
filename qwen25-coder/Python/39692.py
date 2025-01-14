import subprocess\n\ndef open_pdf_at_page(file_path, page_number):\n    # Open the PDF in Adobe Acrobat Reader at the specified page\n    subprocess.Popen(['AcroRd32.exe', '/A', f'page={page_number}', file_path])\n\n# Example usage\nopen_pdf_at_page('example.pdf', 7)