SELECT \n    NAME,\n    SUM(CASE WHEN REF IS NULL THEN 1 ELSE 0 END) AS `null`,\n    SUM(CASE WHEN REF IS NOT NULL THEN 1 ELSE 0 END) AS `not null`\nFROM \n    your_table_name\nGROUP BY \n    NAME;