WITH aliased_query AS (\n  SELECT column1, column2, ... , column1 + column2 AS alias_column\n  FROM your_table\n)\nSELECT *\nFROM aliased_query\nWHERE alias_column > 10;