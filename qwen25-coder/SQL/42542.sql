START TRANSACTION;\n\n-- Set all rows' inuse field to 0\nUPDATE your_table SET inuse = 0;\n\n-- Set the specific row by ID to inuse=1\nUPDATE your_table SET inuse = 1 WHERE id = your_specific_id;\n\nCOMMIT;