CREATE TABLE magic_numbers (\n    id INT PRIMARY KEY,\n    value INT,\n    description VARCHAR(255)\n);\n\nINSERT INTO magic_numbers (id, value, description)\nVALUES\n    (1, 1234, 'No'),\n    (2, 1235, 'Yes');\n\n-- In your procedures, use a JOIN to reference the magic numbers\nSELECT *\nFROM myTbl\nJOIN magic_numbers ON myTbl.myValue = magic_numbers.value;