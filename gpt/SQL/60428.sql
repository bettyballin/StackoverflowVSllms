INSERT INTO file_metadata (id, file_name, file_type, file_location)\n   VALUES (\n       1,\n       'example.pdf',\n       'application/pdf',\n       BFILENAME('BFILE_DIR', 'example.pdf')\n   );