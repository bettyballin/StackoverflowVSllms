-- Create a table to store the documents\nCREATE TABLE Documents (\n    DocumentID INT PRIMARY KEY,\n    DocumentName NVARCHAR(255),\n    DocumentData VARBINARY(MAX)\n);\n\n-- Insert a document into the table\nINSERT INTO Documents (DocumentID, DocumentName, DocumentData)\nVALUES (1, 'SampleDocument.pdf', @DocumentData);\n\n-- Retrieve a document from the table\nSELECT DocumentName, DocumentData\nFROM Documents\nWHERE DocumentID = 1;