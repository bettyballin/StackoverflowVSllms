CREATE TYPE MyTableType AS TABLE (id int);\nGO\n\nCREATE PROCEDURE MyProcedure\n    @myList MyTableType READONLY\nAS\nBEGIN\n    SELECT *\n    FROM tbl\n    WHERE Id IN (SELECT id FROM @myList)\nEND