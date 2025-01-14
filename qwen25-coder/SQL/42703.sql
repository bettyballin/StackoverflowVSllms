SELECT \n    'FirstName' AS ColumnName, COUNT(DISTINCT FirstName) AS DistinctValues, COUNT(*) AS TotalRows \nFROM \n    Profiles\nUNION ALL\nSELECT \n    'LastName', COUNT(DISTINCT LastName), COUNT(*)\nFROM \n    Profiles\nUNION ALL\nSELECT \n    'Address1', COUNT(DISTINCT Address1), COUNT(*)\nFROM \n    Profiles\nUNION ALL\nSELECT \n    'City', COUNT(DISTINCT City), COUNT(*)\nFROM \n    Profiles\nUNION ALL\nSELECT \n    'State', COUNT(DISTINCT State), COUNT(*)\nFROM \n    Profiles\nUNION ALL\nSELECT \n    'Zip', COUNT(DISTINCT Zip), COUNT(*)\nFROM \n    Profiles;