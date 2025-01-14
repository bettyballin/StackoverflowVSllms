SELECT \n    Source.ItemName,\n    SUM(CASE WHEN Int(Date()-Source.DateAdded) > 20 THEN 1 ELSE 0 END) AS Total,\n    SUM(CASE WHEN Int(Date()-Source.DateAdded) BETWEEN 20 AND 44 THEN 1 ELSE 0 END) AS BTWN_20_44,\n    SUM(CASE WHEN Int(Date()-Source.DateAdded) BETWEEN 45 AND 60 THEN 1 ELSE 0 END) AS BTWN_45_60,\n    SUM(CASE WHEN Int(Date()-Source.DateAdded) BETWEEN 61 AND 90 THEN 1 ELSE 0 END) AS BTWN_61_90,\n    SUM(CASE WHEN Int(Date()-Source.DateAdded) BETWEEN 91 AND 180 THEN 1 ELSE 0 END) AS BTWN_91_180,\n    SUM(CASE WHEN Int(Date()-Source.DateAdded) > 180 THEN 1 ELSE 0 END) AS GT_180\nFROM \n    Source\nGROUP BY \n    Source.ItemName;