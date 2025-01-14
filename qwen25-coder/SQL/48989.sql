-- Create the first view\nCREATE VIEW V1\nWITH SCHEMABINDING -- Required for indexed views\nAS\nSELECT 1 AS abc;\n\n-- Create an index on the first view\nCREATE UNIQUE CLUSTERED INDEX idx_V1\nON V1(abc);\n\n-- This view references another view and cannot be indexed\nCREATE VIEW V2\nAS\nSELECT abc \nFROM V1 \nGROUP BY abc;