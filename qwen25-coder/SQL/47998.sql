SELECT * FROM your_table WHERE CHAR_LENGTH(your_field) - CHAR_LENGTH(REPLACE(your_field, ' ', '')) + 1 < 4;