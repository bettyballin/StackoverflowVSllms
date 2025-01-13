DECLARE @count INT\n\nSELECT @count = COUNT(*) \nFROM (\n    SELECT idCover \n    FROM x90..dimCover \n    GROUP BY idCover \n    HAVING COUNT(*) > 1\n) AS subquery\n\nUPDATE forge..dimInteg2 \nSET duplicates = @count \nWHERE dimTable = 'dimCover'