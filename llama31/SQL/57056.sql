SELECT\n  c.Name AS 'CountryName',\n  ISNULL(COUNT(p.[ID]), 0) as 'ProvinceCount'\nFROM \n  Country c\n  LEFT OUTER JOIN [Province] p ON p.[CountryID]=c.[ID] AND p.[Name] <> 'Washington D.C.'\nWHERE\n  c.[ID]=@idParameter