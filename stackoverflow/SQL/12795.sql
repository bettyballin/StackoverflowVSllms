SET arithabort arith_overflow off\nSET @the_date = CAST(@date_string AS DATETIME)\nIF @the_date is NULL\n    set @the_date = getdate()\nSET arithabort arith_overflow o