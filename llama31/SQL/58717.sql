SELECT * FROM table ORDER BY RAND();  // randomize the order of the results\nSELECT * FROM table ORDER BY SUM(column1);  // order by the sum of column1\nSELECT * FROM table ORDER BY column1 + column2;  // order by the sum of column1 and column2\nSELECT * FROM table ORDER BY CONCAT(column1, column2);  // order by the concatenation of column1 and column2