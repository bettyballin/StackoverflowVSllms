SELECT Part.Id AS PartId, Location.Id AS LocationId\nFROM Part, PartEvent PartEventOuter, District, Location\nWHERE \n    PartEventOuter.EventType = '600' \n    AND PartEventOuter.AddressId = Location.AddressId  \n    AND Part.DistrictId = District.Id  \n    AND Part.PartTypeId = 15  \n    AND District.SubRegionId = 11  \n    AND PartEventOuter.PartId = Part.Id  \n    AND PartEventOuter.EventDateTime <= '4/28/2009 4:30pm'  \n    AND NOT EXISTS (\n        SELECT PartEventInner.EventDateTime  \n        FROM PartEvent PartEventInner\n        WHERE PartEventInner.PartId = PartEventOuter.PartId\n            AND PartEventInner.EventDateTime > PartEventOuter.EventDateTime \n            AND PartEventInner.EventDateTime <= '4/30/2009 4:00pm'\n    )