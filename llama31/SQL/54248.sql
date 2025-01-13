-- Create indexes on columns used in the WHERE and JOIN clauses\nCREATE INDEX idx_Field1 ON TableName2 (Field1);\nCREATE INDEX idx_Field2 ON TableName2 (Field2);\nCREATE INDEX idx_Field3 ON TableName2 (Field3);\n\n-- Update statistics to ensure accurate row estimates\nUPDATE STATISTICS TableName2 WITH FULLSCAN;