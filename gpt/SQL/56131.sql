LOAD DATA INFILE '/path/to/file.csv'\nINTO TABLE YourTableName\nFIELDS TERMINATED BY ','\nLINES TERMINATED BY '\n'\nIGNORE 1 LINES; -- if your CSV has a header row