SELECT *\nFROM your_table\nORDER BY some_column -- You must use an ORDER BY clause with OFFSET FETCH\nOFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;