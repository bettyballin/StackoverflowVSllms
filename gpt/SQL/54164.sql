-- Enable Full-Text Search feature\n    USE YourDatabase;\n    GO\n    CREATE FULLTEXT CATALOG ftCatalog AS DEFAULT;\n    GO\n    CREATE FULLTEXT INDEX ON YourTable (YourColumn) KEY INDEX PK_YourTable;\n    GO