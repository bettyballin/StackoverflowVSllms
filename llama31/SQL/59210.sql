LOAD DATA INFILE 'path/to/your/file.csv'\nINTO TABLE your_table_name\nFIELDS TERMINATED BY ','\nENCLOSED BY '\"'\nLINES TERMINATED BY '\n'\nIGNORE 1 ROWS;