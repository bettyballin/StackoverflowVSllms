CREATE PROCEDURE DeleteReferencedRows\nAS\nBEGIN\n    DECLARE @currentId INT;\n\n    -- Create a temporary table to hold the results of your select statement\n    CREATE TABLE #tempIds (Id INT);\n\n    -- Insert the ids from myTable into the temp table\n    INSERT INTO #tempIds (Id)\n    SELECT id FROM myTable WHERE id = -1;\n\n    -- Start the loop with a cursor on the temporary table\n    DECLARE cur CURSOR FOR\n        SELECT Id FROM #tempIds;\n\n    OPEN cur;\n\n    FETCH NEXT FROM cur INTO @currentId;\n    WHILE @@FETCH_STATUS = 0\n    BEGIN\n        -- Perform your delete operation on myOtherTable for each id\n        DELETE FROM myOtherTable WHERE columnReferencingMyTable = @currentId;\n\n        -- Fetch the next id from the cursor\n        FETCH NEXT FROM cur INTO @currentId;\n    END\n\n    CLOSE cur;\n    DEALLOCATE cur;\n\n    DROP TABLE #tempIds;  -- Clean up the temporary table\n\nEND