-- Example query to find duplicate rows based on a subset of columns\nSELECT column1, column2, COUNT(*)\nFROM your_huge_table\nGROUP BY column1, column2\nHAVING COUNT(*) > 1;