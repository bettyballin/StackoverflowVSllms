DECLARE @CustomerId INT\nDECLARE CustomerCursor CURSOR FOR\nSELECT CustomerId FROM Customers\n\nOPEN CustomerCursor\nFETCH NEXT FROM CustomerCursor INTO @CustomerId\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    -- Perform some operation on each customer\n    FETCH NEXT FROM CustomerCursor INTO @CustomerId\nEND\n\nCLOSE CustomerCursor\nDEALLOCATE CustomerCursor