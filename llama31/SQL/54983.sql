CREATE TABLE TestTable (\n    VarCharColumn varchar(50),\n    NVarCharColumn nvarchar(50)\n);\n\nINSERT INTO TestTable (VarCharColumn, NVarCharColumn)\nVALUES ('Hello, World!', 'Hello, World!');\n\nEXEC sp_spaceused 'TestTable';