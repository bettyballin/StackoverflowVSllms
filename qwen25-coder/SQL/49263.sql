SELECT \n    ROW_NUMBER() OVER (ORDER BY name) AS row_number,\n    name\nFROM \n    friends\nORDER BY \n    name;