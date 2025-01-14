DECLARE @fk_name NVARCHAR(128) = 'YourForeignKeyName';\nDECLARE @fk_exists BIT;\n\nSELECT TOP 1 \n    @fk_exists = CASE WHEN KCU.CONSTRAINT_NAME IS NOT NULL THEN 1 ELSE 0 END\nFROM \n    INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS TC\nINNER JOIN \n    INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS KCU ON TC.CONSTRAINT_NAME = KCU.CONSTRAINT_NAME\nWHERE \n    TC.CONSTRAINT_TYPE = 'FOREIGN KEY' AND\n    KCU.CONSTRAINT_NAME = @fk_name;\n\nIF (@fk_exists IS NULL OR @fk_exists = 0)\nBEGIN\n    -- Add your foreign key constraint creation script here\n    ALTER TABLE YourTableName\n    ADD CONSTRAINT YourForeignKeyName\n    FOREIGN KEY (YourColumnName)\n    REFERENCES ReferencedTableName(ReferencedColumnName);\nEND;