CREATE PROCEDURE dbo.OuterProcedure\nAS\nBEGIN\n    DECLARE @TempTable1 dbo.RecordSet1;\n    DECLARE @TempTable2 dbo.RecordSet2;\n\n    EXEC dbo.CommonProcedure @TempTable1 OUTPUT, @TempTable2 OUTPUT;\n\n    -- Now you can use @TempTable1 and @TempTable2 as needed in the outer procedure\n    SELECT * FROM @TempTable1;\n    SELECT * FROM @TempTable2;\nEND;