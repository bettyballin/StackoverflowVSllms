SELECT *\nFROM table1\nJOIN table2 ON table1.column = table2.column\nJOIN table3 ON table2.column = table3.column\n-- Continue joining as necessary\nWHERE -- Apply your conditions here