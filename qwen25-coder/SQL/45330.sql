-- Create the new character column\nUPDATE temptable \nSET char_column = CASE \n                    WHEN numeric_column <= 1 THEN 'SP'\n                    WHEN numeric_column > 1 THEN 'FA'\n                  END;