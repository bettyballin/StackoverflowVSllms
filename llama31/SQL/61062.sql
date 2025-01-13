WITH RankedCTE AS (\n  SELECT \n    PKCol,\n    ColA,\n    ColB,\n    ColC,\n    ColD,\n    ColE,\n    ROW_NUMBER() OVER (PARTITION BY PKCol ORDER BY ColA DESC) AS RowNumA,\n    ROW_NUMBER() OVER (PARTITION BY PKCol ORDER BY ColB DESC) AS RowNumB,\n    ROW_NUMBER() OVER (PARTITION BY PKCol ORDER BY ColC DESC) AS RowNumC,\n    ROW_NUMBER() OVER (PARTITION BY PKCol ORDER BY ColD DESC) AS RowNumD,\n    ROW_NUMBER() OVER (PARTITION BY PKCol ORDER BY ColE DESC) AS RowNumE\n  FROM YourTable\n)\nSELECT \n  PKCol,\n  MAX(CASE WHEN RowNumA = 1 THEN ColA END) AS ColA,\n  MAX(CASE WHEN RowNumB = 1 THEN ColB END) AS ColB,\n  MAX(CASE WHEN RowNumC = 1 THEN ColC END) AS ColC,\n  MAX(CASE WHEN RowNumD = 1 THEN ColD END) AS ColD,\n  MAX(CASE WHEN RowNumE = 1 THEN ColE END) AS ColE\nFROM RankedCTE\nGROUP BY PKCol;