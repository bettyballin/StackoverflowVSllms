LOAD DATA INFILE '/path/to/yourfile.csv'\n   INTO TABLE your_database.your_table\n   FIELDS TERMINATED BY ','\n   ENCLOSED BY '"'\n   LINES TERMINATED BY '\n'\n   IGNORE 1 ROWS;