ALTER TABLE Table\nADD CONSTRAINT CK_Table_Column_Range CHECK (\n   Column >= 0 AND Column <= 100 --Inclusive\n)