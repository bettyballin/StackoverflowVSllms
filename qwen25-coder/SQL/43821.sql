ALTER TABLE YourTableNameHere ADD Seq INT;\n\nWITH Numbered AS (\n    SELECT \n        Code, \n        Number,\n        ROW_NUMBER() OVER (PARTITION BY Code ORDER BY Number ASC) AS rn\n    FROM \n        YourTableNameHere\n)\nUPDATE YourTableNameHere\nSET Seq = Numbered.rn\nFROM Numbered\nWHERE YourTableNameHere.Code = Numbered.Code AND YourTableNameHere.Number = Numbered.Number;