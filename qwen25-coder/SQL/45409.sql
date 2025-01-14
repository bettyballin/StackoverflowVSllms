-- Fetching data with 'bse' in the action field\nSELECT * FROM your_table_name WHERE action LIKE '%bse%';\n\n-- Inserting the same data into another table (assuming it has the same structure)\nINSERT INTO new_table_name (column1, column2, ..., action)\nSELECT column1, column2, ..., action \nFROM your_table_name \nWHERE action LIKE '%bse%';