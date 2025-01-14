BEGIN TRANSACTION;\n\n-- Check if record exists for current Year and Month, and lock it.\nSELECT NextNumber \nFROM SequenceGenerator WITH (UPDLOCK)\nWHERE Year = @Year AND Month = @Month;\n\nIF @@ROWCOUNT = 0 -- Record does not exist, insert new row with next number as 1\nBEGIN\n    INSERT INTO SequenceGenerator (Year, Month, NextNumber) VALUES (@Year, @Month, 1);\n    SET @NextNumber = 1;\nEND\nELSE -- Update the existing record to increment the NextNumber\nBEGIN\n    UPDATE SequenceGenerator \n    SET NextNumber = NextNumber + 1 \n    OUTPUT INSERTED.NextNumber AS NextNumber\n    WHERE Year = @Year AND Month = @Month;\n\n    SET @NextNumber = (SELECT SCOPE_IDENTITY()); -- Fetch updated next number\nEND\n\nCOMMIT TRANSACTION;