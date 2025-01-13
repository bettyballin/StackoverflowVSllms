CREATE VIEW MyView AS\nSELECT \n    CASE \n        WHEN CHARINDEX('DSP', MyColumn) > 0 THEN \n            SUBSTRING(MyColumn, CHARINDEX('DSP', MyColumn) + 4, 5)\n        WHEN CHARINDEX('DISCH', MyColumn) > 0 THEN \n            SUBSTRING(MyColumn, CHARINDEX('DISCH', MyColumn) + 6, 5)\n        ELSE NULL\n    END AS MyDate\nFROM MyTable