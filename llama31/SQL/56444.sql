DECLARE @id INT;\n\nDECLARE cur CURSOR FOR \nSELECT id FROM myTable WHERE id = -1;\n\nOPEN cur;\n\nFETCH NEXT FROM cur INTO @id;\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    DELETE FROM myOtherTable WHERE id = @id;\n    FETCH NEXT FROM cur INTO @id;\nEND\n\nCLOSE cur;\nDEALLOCATE cur;