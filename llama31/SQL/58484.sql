SELECT OWNER, NAME, LINE, TEXT\nFROM ALL_SOURCE\nWHERE TYPE = 'PROCEDURE' AND UPPER(TEXT) LIKE '%MYTEXT%';