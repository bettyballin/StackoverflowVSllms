CASE \n  WHEN PATINDEX('%[^0]%', str_col) = 0 THEN '0' \n  ELSE SUBSTRING(str_col, PATINDEX('%[^0]%', str_col), LEN(str_col)) \nEND