UPDATE P\n    SET\n        P.FirstName = S.FirstName,\n        P.LastName = S.LastName,\n        P.Address = S.Address,\n        P.PhoneNumber = S.PhoneNumber\n    FROM\n        ProductionTable P\n    CROSS APPLY\n        (SELECT TOP 1 FirstName, LastName, Address, PhoneNumber FROM SampleNames ORDER BY NEWID()) AS S;