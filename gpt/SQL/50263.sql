UPDATE your_table \n    SET your_column = CONVERT(BINARY CONVERT(your_column USING latin1) USING utf8);