CREATE PROCEDURE MyProcedure\n    @OutputParam INT OUTPUT\nAS\nBEGIN\n    -- your code here\n    SET @OutputParam = SCOPE_IDENTITY()\nEND