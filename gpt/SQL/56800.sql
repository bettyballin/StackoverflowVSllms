LOAD DATA LOCAL INFILE 'tblAuction1.txt' \n   INTO TABLE Auctions \n   FIELDS TERMINATED BY ';' \n   ENCLOSED BY '"' \n   ESCAPED BY '\\'\n   CHARACTER SET utf8mb4;