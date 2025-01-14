SELECT \n    absence_date,\n    CASE \n        WHEN MONTH(absence_date) > 7 THEN CAST(YEAR(absence_date) AS VARCHAR(4)) + '/' + CAST(YEAR(absence_date) + 1 AS VARCHAR(4))\n        ELSE CAST(YEAR(absence_date) - 1 AS VARCHAR(4)) + '/' + CAST(YEAR(absence_date) AS VARCHAR(4))\n    END AS academic_year\nFROM \n    your_table_name;