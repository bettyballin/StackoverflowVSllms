UPDATE your_table\nSET your_column = REPLACE(your_column, UNISTR('\0013'), '')\nWHERE your_column LIKE '%' || UNISTR('\0013') || '%';