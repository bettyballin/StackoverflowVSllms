SELECT Name, Age, @row_number:=@row_number + 1 AS Ranking\nFROM your_table_name, (SELECT @row_number:=0) AS t\nORDER BY Age;