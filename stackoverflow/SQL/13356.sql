SELECT * FROM myTable\nWHERE ...\nORDER BY CASE WHEN myDate IS NULL THEN 1 ELSE 0 END, myDate;