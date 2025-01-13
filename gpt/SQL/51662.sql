CREATE PROCEDURE SyncTables\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    MERGE INTO table2 AS target\n    USING table1 AS source\n    ON (target.PrimaryKeyColumn = source.PrimaryKeyColumn)\n    WHEN MATCHED THEN \n        UPDATE SET target.UpdateTimestamp = GETDATE()\n    WHEN NOT MATCHED BY TARGET THEN\n        INSERT (PrimaryKeyColumn, Column1, Column2, ..., ColumnN, UpdateTimestamp)\n        VALUES (source.PrimaryKeyColumn, source.Column1, source.Column2, ..., source.ColumnN, GETDATE());\n\n    SET NOCOUNT OFF;\nEND