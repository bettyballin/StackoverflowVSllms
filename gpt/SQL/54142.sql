-- Create a table with VARCHAR(MAX) column\nCREATE TABLE MyTable (\n    ID INT PRIMARY KEY,\n    Col1 VARCHAR(MAX)\n);\n\n-- Create a Full-Text Index on the table\nCREATE FULLTEXT CATALOG MyFullTextCatalog AS DEFAULT;\nCREATE FULLTEXT INDEX ON MyTable(Col1) KEY INDEX PK_MyTable_ID;\n\n-- Search using the CONTAINS clause\nSELECT * FROM MyTable\nWHERE CONTAINS (Col1, 'MyToken');