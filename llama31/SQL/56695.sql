SELECT *\nFROM your_table\nWHERE date > (SELECT date FROM your_table WHERE primary_key = ?)\nORDER BY date ASC\nLIMIT 1;