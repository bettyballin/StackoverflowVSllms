WITH ranked AS (\n    SELECT \n        Model,\n        Make,\n        datepart(year,[Registration]) AS YearRegistered,\n        SalePrice,\n        ROW_NUMBER() OVER (PARTITION BY Model, Make ORDER BY datepart(year,[Registration])) AS rn\n    FROM \n        [VehicleSales]\n)\nSELECT \n    YearRegistered,\n    MIN(SalePrice),\n    Model,\n    Make\nFROM \n    ranked\nWHERE \n    rn = 1\nGROUP BY \n    Model, Make