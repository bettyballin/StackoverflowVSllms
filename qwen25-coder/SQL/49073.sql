ALTER TABLE YourTable ADD UniqueColumn AS (\n    CASE \n        WHEN LEN(YourNVarcharColumn) > 0 THEN YourNVarcharColumn \n        ELSE 'FIXED_STRING_NEVER_IN_COLUMN' \n    END\n);\n\nCREATE UNIQUE INDEX IX_UniqueColumn ON YourTable (UniqueColumn);