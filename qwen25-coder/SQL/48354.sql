SELECT DISTINCT TRIM(name) AS name \nFROM log \nWHERE TRIM(name) IS NOT NULL AND UPPER(TRIM(name)) LIKE '%.EDIT%';