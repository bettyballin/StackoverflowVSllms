-- Create a table with some data\nCREATE TABLE TestTable (ID INT, Value INT);\nINSERT INTO TestTable (ID, Value) VALUES (1, 10), (2, 20), (3, 30);\n\n-- Add a CHECK constraint with WITH CHECK\nALTER TABLE TestTable WITH CHECK ADD CONSTRAINT CK_Value CHECK (Value > 10);\n-- This will fail because the value 10 does not comply with the constraint\n\n-- Add a CHECK constraint without WITH CHECK\nALTER TABLE TestTable ADD CONSTRAINT CK_Value CHECK (Value > 10);\n-- This will succeed, but the constraint is not checked immediately\n\n-- Enable the constraint and check existing data\nALTER TABLE TestTable CHECK CONSTRAINT CK_Value;\n-- This will fail because the value 10 does not comply with the constraint