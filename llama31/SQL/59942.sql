CREATE TABLE MyTable (\n    Id INT PRIMARY KEY,\n    Col1 VARCHAR(MAX)\n);\n\nCREATE FULLTEXT CATALOG MyCatalog AS DEFAULT;\nCREATE FULLTEXT INDEX ON MyTable (Col1) KEY INDEX PK_MyTable_Id;\n\nINSERT INTO MyTable (Id, Col1) VALUES (1, 'This is a test string');\n\n-- Using LIKE clause\nSELECT * FROM MyTable WHERE Col1 LIKE '%test%';\n\n-- Using CONTAINS clause\nSELECT * FROM MyTable WHERE CONTAINS (Col1, 'test');