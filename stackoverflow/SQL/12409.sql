SELECT [VehicleID]\n     , [Name]\n     , (STUFF((SELECT CAST(', ' + [City] AS VARCHAR(MAX)) \n         FROM [Location] \n         WHERE (VehicleID = Vehicle.VehicleID) \n         FOR XML PATH ('')), 1, 2, '')) AS Locations\nFROM [Vehicle]