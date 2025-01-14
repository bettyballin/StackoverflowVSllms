DECLARE @ID INT, @column1 INT, @column2 VARCHAR(50), @column3 VARCHAR(50), @newID INT;\n\n-- Declare a cursor to select rows from table xyz\nDECLARE xyz_cursor CURSOR FOR\nSELECT ID, column1, column2, column3\nFROM xyz;\n\n-- Open the cursor\nOPEN xyz_cursor;\n\n-- Fetch the first row\nFETCH NEXT FROM xyz_cursor INTO @ID, @column1, @column2, @column3;\n\n-- Loop through all rows\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    -- Insert into table abc and retrieve the new ID\n    INSERT INTO abc (column1, column2, column3)\n    VALUES (@column1, @column2, @column3);\n\n    SET @newID = SCOPE_IDENTITY();\n\n    -- Update xyz table with the new ID\n    UPDATE xyz SET column10 = @newID WHERE ID = @ID;\n\n    -- Fetch the next row\n    FETCH NEXT FROM xyz_cursor INTO @ID, @column1, @column2, @column3;\nEND;\n\n-- Close and deallocate the cursor\nCLOSE xyz_cursor;\nDEALLOCATE xyz_cursor;