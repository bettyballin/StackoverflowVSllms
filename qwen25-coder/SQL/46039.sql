SELECT REPLACE(REPLACE(REPLACE(your_string, CHR(0), '\x00'), \n                          CHR(9), '\t'),\n               CHR(10), '\n') AS translated_string\nFROM your_table;