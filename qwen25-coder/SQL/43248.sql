SELECT field FROM test_table WHERE condition='test'\n   INTO OUTFILE '/absolute/path/to/tmp/test.csv'\n   FIELDS TERMINATED BY ','\n   ENCLOSED BY '"'\n   LINES TERMINATED BY '\n';