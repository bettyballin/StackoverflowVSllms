header('Content-Type: application/pdf');\nheader('Content-Disposition: attachment; filename="downloaded.pdf"');\nheader('Content-Transfer-Encoding: binary');\nheader('Accept-Ranges: bytes');\nob_clean();\nflush();\nreadfile('path_to_your_pdf_file.pdf');