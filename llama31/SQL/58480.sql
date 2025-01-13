CREATE TYPE MyTableType AS TABLE (\n    Column1 INT,\n    Column2 VARCHAR(50),\n    Column3 DATETIME\n);\n\nCREATE PROCEDURE MyProcedure\n    @MyTableParam MyTableType READONLY\nAS\nBEGIN\n    -- Use the table-valued parameter\n    SELECT * FROM @MyTableParam;\nEND;