CREATE PROCEDURE dbo.MyProcedure\n  @Param BIT = NULL\nAS\nBEGIN\n  SELECT *\n  FROM dbo.SomeTable T\n  WHERE @Param IS NULL OR T.SomeColumn = @Param;\nEND