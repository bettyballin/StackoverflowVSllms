SELECT * INTO OUTFILE '/path/to/your/file.csv'\nFIELDS TERMINATED BY ',' \nENCLOSED BY '"'\nLINES TERMINATED BY '\n'\nFROM your_table_name;