DECLARE @user_id INT\n\nDECLARE cur CURSOR FOR\nSELECT user_id FROM your_table\n\nOPEN cur\n\nFETCH NEXT FROM cur INTO @user_id\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    EXEC your_stored_procedure @user_id\n    FETCH NEXT FROM cur INTO @user_id\nEND\n\nCLOSE cur\nDEALLOCATE cur