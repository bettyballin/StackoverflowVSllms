ALTER TABLE MyTable\nADD CONSTRAINT CK_MyTable_isDefault CHECK (\n    isDefault = 0 OR NOT EXISTS (\n        SELECT 1 FROM MyTable t2\n        WHERE t2.FormID = FormID AND t2.isDefault = 1 AND t2.ID <> ID\n    )\n);