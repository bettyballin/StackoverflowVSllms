SELECT *\nFROM \n(SELECT column1 + column2 AS alias_column FROM your_table) AS derived_table\nWHERE derived_table.alias_column > 10