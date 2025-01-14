SELECT *\nFROM HastaKurumlari\nWHERE CONVERT(SMALLDATETIME, '21-05-2009', 103) BETWEEN startDate AND endDate\nAND endDate IS NOT NULL\n\nUNION ALL\n\nSELECT *\nFROM HastaKurumlari\nWHERE CONVERT(SMALLDATETIME, '21-05-2009', 103) >= startDate\nAND endDate IS NULL;