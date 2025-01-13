SELECT \n    datepart(year,[Registration]) AS YearRegistered,\n    Model, \n    Make,\n    MIN(SalePrice) AS StartingPrice\n\nFROM [VehicleSales]\nGROUP BY \n    datepart(year,[Registration]),\n    Model, \n    Make