SELECT * \nFROM TABLE1 t1 \nLEFT OUTER JOIN TABLE1 t2 \n    ON ASCII(t2.Letter) - 1 = ASCII(t1.Letter) \n    AND t1.Date = t2.Date\nWHERE t2.id IS NULL