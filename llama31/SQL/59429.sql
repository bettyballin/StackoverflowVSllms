UPDATE your_table\nSET your_field = REPLACE(your_field, 'foo', 'bar')\nWHERE your_field LIKE '%foo%';