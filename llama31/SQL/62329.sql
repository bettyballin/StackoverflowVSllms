SELECT @row_num:=@row_num+1 AS row_index, column_name\nFROM table_name, (SELECT @row_num:=0) AS r