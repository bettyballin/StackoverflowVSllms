CREATE TABLE sandbox (\n  a NUMBER(10,0),\n  b NUMBER(10,0)\n);\n\n-- Create a unique index with a function that returns a constant value for NULLs\nCREATE UNIQUE INDEX sandbox_idx ON sandbox (\n  CASE WHEN a IS NULL THEN -1 ELSE a END,\n  CASE WHEN b IS NULL THEN -1 ELSE b END\n);\n\n-- Insert statements for testing\nINSERT INTO sandbox VALUES (1, 1); -- accepted\nINSERT INTO sandbox VALUES (1, 2); -- accepted\nINSERT INTO sandbox VALUES (1, 1); -- rejected\n\nINSERT INTO sandbox VALUES (1, NULL); -- accepted\nINSERT INTO sandbox VALUES (2, NULL); -- accepted\nINSERT INTO sandbox VALUES (1, NULL); -- accepted\n\nINSERT INTO sandbox VALUES (NULL, 1); -- accepted\nINSERT INTO sandbox VALUES (NULL, 2); -- accepted\nINSERT INTO sandbox VALUES (NULL, 1); -- accepted\n\nINSERT INTO sandbox VALUES (NULL, NULL); -- accepted\nINSERT INTO sandbox VALUES (NULL, NULL); -- accepted