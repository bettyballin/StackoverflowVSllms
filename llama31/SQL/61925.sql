UPDATE your_table\nSET your_column = UPPER(LEFT(your_column, 2)) + LTRIM(RIGHT(your_column, LEN(your_column) - 2))