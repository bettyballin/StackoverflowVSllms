SELECT DISTINCT CAST(YEAR(datecol) AS VARCHAR(4)) + '/' + RIGHT('0' + CAST(MONTH(datecol) AS VARCHAR(2)), 2) + '/1' as dt\nFROM YourTable\nORDER BY YEAR(datecol), MONTH(datecol);