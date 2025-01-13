CREATE PROCEDURE UpsertMyTable\n    @ID INT,\n    @Col1 VARCHAR(255),\n    @Col2 VARCHAR(255)\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    MERGE myTable AS target\n    USING (VALUES (@ID, @Col1, @Col2)) AS source (ID, Col1, Col2)\n    ON (target.ID = source.ID)\n    WHEN MATCHED THEN\n        UPDATE SET Col1 = source.Col1, Col2 = source.Col2\n    WHEN NOT MATCHED THEN\n        INSERT (ID, Col1, Col2)\n        VALUES (source.ID, source.Col1, source.Col2);\nEND;