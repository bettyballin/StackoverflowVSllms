SELECT field1 \nFROM your_table_name \nWHERE id = $id \nORDER BY CASE \n    WHEN criteria = $criteria THEN 0 \n    ELSE 1 \nEND \nLIMIT 5;