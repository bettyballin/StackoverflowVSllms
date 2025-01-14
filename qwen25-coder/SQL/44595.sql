WITH table1 AS (\n    SELECT field1,\n           field2\n    FROM some_table\n),\ntable2 AS (\n    SELECT t1.field1,\n           field3\n    FROM other_table ot\n    JOIN table1 t1 ON ot.some_common_field = t1.some_common_field  -- Use an appropriate join condition\n)\nSELECT ...\nFROM table1, table2\nWHERE ...;