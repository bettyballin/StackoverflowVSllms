SELECT emp_id, name, occupation\nFROM your_table\nFETCH FIRST 3 ROWS WITH TIES PERCENT OPTION GROUP BY occupation;