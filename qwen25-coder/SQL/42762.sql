ALTER TABLE ForeignKeyTable NOCHECK CONSTRAINT FK_YourTable_ForeignKeyTable;\n   -- Or\n   CREATE TABLE #GuidMapping (OldGuid UNIQUEIDENTIFIER, NewSequentialGuid UNIQUEIDENTIFIER);\n   INSERT INTO #GuidMapping SELECT GuidColumn, SequentialGuid FROM YourTable;