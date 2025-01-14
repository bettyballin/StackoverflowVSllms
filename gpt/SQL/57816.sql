CREATE TABLE documents (\n    id NUMBER PRIMARY KEY,\n    filename VARCHAR2(255),\n    file_location BFILE,\n    metadata CLOB\n);\n\n-- Example to insert a new document\nINSERT INTO documents (id, filename, file_location, metadata)\nVALUES (1, 'example.pdf', BFILENAME('YOUR_DIRECTORY_OBJECT', 'example.pdf'), 'Document metadata');