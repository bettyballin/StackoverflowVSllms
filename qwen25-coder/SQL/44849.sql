SELECT p.* \nFROM Properties p\nLEFT JOIN Countries c ON p.Country_ID = c.CountryID\nLEFT JOIN Regions r ON p.RegionID = r.RegionID\nLEFT JOIN Areas a ON p.AreaID = a.AreaID\nWHERE c.CountryID IS NULL OR r.RegionID IS NULL OR a.AreaID IS NULL;