SELECT DISTINCT City AS Keyword, Country AS Sideinfo\nFROM your_table\nWHERE CONCAT(City, ' ', Country) LIKE '%keyword%'\nUNION\nSELECT DISTINCT Country AS Keyword, 'Country' AS Sideinfo\nFROM your_table\nWHERE Country LIKE '%keyword%';