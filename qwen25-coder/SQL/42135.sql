CREATE TABLE Numbers (n int);\nINSERT INTO Numbers VALUES (1), (2), ..., (10); -- Insert up to the number you need\n\nSELECT n AS LEVEL FROM Numbers WHERE n <= 10;