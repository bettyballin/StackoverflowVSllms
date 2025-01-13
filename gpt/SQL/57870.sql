-- Create the temporary table with the same structure\nCREATE TEMPORARY TABLE temp_table (\n    Code VARCHAR(10),\n    SubCode VARCHAR(10),\n    Version INT,\n    Status CHAR(1)\n);\n\n-- Insert the filtered records into the temporary table\nINSERT INTO temp_table (Code, SubCode, Version, Status)\nSELECT t1.Code, t1.SubCode, t1.Version, t1.Status\nFROM your_table t1\nWHERE NOT EXISTS (\n    SELECT 1\n    FROM your_table t2\n    WHERE t2.Code = t1.Code\n    AND t2.Status <> 'A'\n)\nGROUP BY t1.Code, t1.SubCode, t1.Version, t1.Status;