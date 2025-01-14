-- Create a table variable for intermediate storage\nDECLARE @TempTable TABLE (\n    DarkhastFaktor INT,\n    Mablagh FLOAT\n);\n\nINSERT INTO Treasury.DariaftPardakhtDarkhastFaktor (DarkhastFaktor, DariaftPardakht, Mablagh, CodeVazeiat, \n                                                ZamaneTakhsiseFaktor, MarkazPakhsh, ShomarehFaktor, User)\n    VALUES (@DarkhastFaktor, @DariaftPardakht, @Mablagh, @CodeVazeiat, \n            @ZamaneTakhsiseFaktor, @MarkazPakhsh, @ShomarehFaktor, @User);\n\n-- Insert the new row into the table variable for calculation\nINSERT INTO @TempTable (DarkhastFaktor, Mablagh)\n    VALUES (@DarkhastFaktor, @Mablagh);\n\n-- Use the table variable in the constraint logic\nDECLARE @SumMablagh FLOAT;\nSELECT @SumMablagh = ISNULL(SUM(Mablagh), 0)\nFROM (\n    SELECT Mablagh FROM Treasury.DariaftPardakhtDarkhastFaktor WHERE DarkhastFaktor = @DarkhastFaktor\n    UNION ALL\n    SELECT Mablagh FROM @TempTable WHERE DarkhastFaktor = @DarkhastFaktor\n) AS CombinedData;\n\nDECLARE @Mablagh FLOAT;\nSELECT @Mablagh = ISNULL(MablaghKhalesFaktor, 0)\nFROM Sales.DarkhastFaktor WHERE DarkhastFaktor = @DarkhastFaktor;\n\n-- Constraint logic\nIF @Mablagh - @SumMablagh < -1\nBEGIN\n    RAISERROR ('Constraint violated', 16, 1);\nEND;