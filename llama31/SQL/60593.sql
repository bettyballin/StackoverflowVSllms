SELECT  *\nFROM    (\n        SELECT  *\n        FROM    mytable\n        ORDER BY\n                dbms_random.value\n        )\nWHERE rownum <= 1000