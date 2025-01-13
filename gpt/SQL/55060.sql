SELECT \n    datetime_column1,\n    value_column1,\n    AVG(value_column1) OVER (\n        ORDER BY datetime_column1 \n        ROWS BETWEEN 19 PRECEDING AND CURRENT ROW\n    ) AS moving_average\nFROM \n    table1\nWHERE \n    datetime_column1 >= '2009-01-01 00:00:00'\nORDER BY \n    datetime_column1;