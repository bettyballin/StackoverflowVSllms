CREATE TABLE temp1 AS\nSELECT \n    ROW_NUMBER() OVER (ORDER BY col1, col2, col3) AS insert_num,\n    col1,\n    col2,\n    col3\nFROM tables a \nJOIN b ON a.id = b.id;