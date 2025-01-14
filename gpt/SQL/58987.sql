-- Ensure an index exists on some_string_field\nCREATE INDEX idx_some_string_field ON your_large_table(some_string_field);\n\n-- Use the LIKE clause for better performance\nSELECT * FROM your_large_table\nWHERE some_string_field LIKE '2505%';