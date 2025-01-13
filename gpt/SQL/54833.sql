IF NOT EXISTS (\n    SELECT 1\n    FROM sys.foreign_keys AS fk\n    INNER JOIN sys.foreign_key_columns AS fkc\n        ON fk.object_id = fkc.constraint_object_id\n    INNER JOIN sys.columns AS c\n        ON fkc.parent_column_id = c.column_id\n        AND fkc.parent_object_id = c.object_id\n    WHERE fk.parent_object_id = OBJECT_ID('YourTableName')\n        AND c.name = 'YourColumnName'\n)\nBEGIN\n    -- Add your script to create the foreign key here\n    ALTER TABLE YourTableName\n    ADD CONSTRAINT FK_YourForeignKeyName\n    FOREIGN KEY (YourColumnName)\n    REFERENCES OtherTableName (OtherColumnName)\nEND