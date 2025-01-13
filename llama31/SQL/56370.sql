CREATE OR REPLACE PROCEDURE YourOracleProcedureName(\n    param1 IN VARCHAR2,\n    param2 IN VARCHAR2,\n    result_cursor OUT SYS_REFCURSOR\n)\nAS\nBEGIN\n    INSERT INTO your_table (column1, column2)\n    VALUES (param1, param2);\n\n    OPEN result_cursor FOR\n    SELECT column1, column2\n    FROM your_table\n    WHERE rowid = (SELECT MAX(rowid) FROM your_table);\nEND;