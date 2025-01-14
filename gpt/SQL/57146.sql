-- Example of using a cursor in T-SQL\nDECLARE @id INT, @name NVARCHAR(50)\n\n-- Declare the cursor\nDECLARE myCursor CURSOR FOR\nSELECT id, name FROM myTable\n\n-- Open the cursor\nOPEN myCursor\n\n-- Fetch the first row\nFETCH NEXT FROM myCursor INTO @id, @name\n\n-- Loop through the cursor rows\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    -- Perform some operations\n    PRINT 'ID: ' + CAST(@id AS NVARCHAR) + ', Name: ' + @name\n\n    -- Fetch the next row\n    FETCH NEXT FROM myCursor INTO @id, @name\nEND\n\n-- Close and deallocate the cursor\nCLOSE myCursor\nDEALLOCATE myCursor