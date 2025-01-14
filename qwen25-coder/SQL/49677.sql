CREATE TEMPORARY TABLE temp_ids (id INT PRIMARY KEY);\n\n-- Insert the required IDs into the temporary table\nINSERT INTO temp_ids (id) VALUES (1), (2), (3), ...; -- Add more as needed\n\nSELECT * \nFROM tab1 \nWHERE tab1.id IN (SELECT id FROM temp_ids);