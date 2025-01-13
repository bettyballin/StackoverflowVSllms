DECLARE @Column1 INT, @Column2 NVARCHAR(100);\n\nDECLARE cursor_fast_forward CURSOR FAST_FORWARD FOR\nSELECT Column1, Column2\nFROM YourTable\nWHERE SomeCondition = 'value';\n\nOPEN cursor_fast_forward;\n\nFETCH NEXT FROM cursor_fast_forward INTO @Column1, @Column2;\n\nWHILE @@FETCH_STATUS = 0\nBEGIN\n    -- Perform your logic here\n    FETCH NEXT FROM cursor_fast_forward INTO @Column1, @Column2;\nEND;\n\nCLOSE cursor_fast_forward;\nDEALLOCATE cursor_fast_forward;