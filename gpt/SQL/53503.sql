WITH CityRanked AS (\n    SELECT \n        country, \n        state, \n        city, \n        postalcode, \n        areacode,\n        ROW_NUMBER() OVER (PARTITION BY city ORDER BY postalcode) as rn\n    FROM \n        city_database\n)\nSELECT \n    country, \n    state, \n    city, \n    postalcode, \n    areacode\nFROM \n    CityRanked\nWHERE \n    rn = 1;