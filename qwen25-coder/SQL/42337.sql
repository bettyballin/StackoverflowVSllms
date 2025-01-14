WITH DateRange AS (\n    SELECT MIN(entryts) AS dt FROM usagelog\n    UNION ALL\n    SELECT DATEADD(d, 1, dt) FROM DateRange WHERE dt < (SELECT MAX(entryts) FROM usagelog)\n)\n\nSELECT \n   dr.dt as date,\n   COALESCE(COUNT(ul.userid), 0) as numlogins,\n   COALESCE(COUNT(DISTINCT ul.userid), 0) as numusers\nFROM \n   DateRange dr\nLEFT JOIN \n    usagelog ul ON CAST(dr.dt AS DATE) = CAST(entryts AS DATE)\nGROUP BY \n   dr.dt\nOPTION (MAXRECURSION 32767);