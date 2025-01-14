BEGIN TRY\n    -- Your insert statement\n    INSERT INTO CommReceipt (CR_Key, Column1, Column2)\n    SELECT CR_Key, Column1, Column2 FROM StagingTable;\nEND TRY\nBEGIN CATCH\n    -- Handle the error, e.g., log to an error table\n    INSERT INTO ErrorLog (ErrorMessage, ErrorTime)\n    VALUES (ERROR_MESSAGE(), GETDATE());\nEND CATCH