SET @row_number = 0;\nSELECT \n    (@row_number:=@row_number + 1) AS row_num,\n    id, \n    name \nFROM \n    people \nWHERE \n    name = 'Spiewak'\nORDER BY \n    id;