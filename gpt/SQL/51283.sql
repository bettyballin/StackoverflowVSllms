SELECT field FROM test_table WHERE condition='test'\n    INTO OUTFILE '/path_to_writable_directory/test.csv'\n    FIELDS TERMINATED BY ','\n    ENCLOSED BY '"'\n    LINES TERMINATED BY '\n';