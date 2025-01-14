CREATE OR REPLACE PROCEDURE InsertOrUpdateMyTable(p_id IN INTEGER, p_col1 IN VARCHAR2, p_col2 IN VARCHAR2) IS\nBEGIN\n    MERGE INTO MyTable mt\n    USING (SELECT 1 FROM DUAL) a\n    ON (mt.ID = p_id)\n    WHEN MATCHED THEN\n        UPDATE SET\n            mt.Col1 = COALESCE(p_col1, mt.Col1),\n            mt.Col2 = COALESCE(p_col2, mt.Col2)\n    WHEN NOT MATCHED THEN\n        INSERT (ID, Col1, Col2)\n        VALUES (p_id, p_col1, p_col2);\nEND InsertOrUpdateMyTable;\n/