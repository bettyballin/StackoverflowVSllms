SELECT\nCASE WHEN UPPER(fldField) LIKE 'YYY' THEN 'OTH' ELSE 'XXX' END AS newField\nFROM tmpTable