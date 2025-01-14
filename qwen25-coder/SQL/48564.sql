CREATE PROCEDURE [dbo].[TestTable_Search]\n    @Col1 int,\n    @Col2 uniqueidentifier,\n    @Col3 datetime,\n    @Col4 datetime,\n    @ID1 varchar(10)\nAS\n\nSET TRANSACTION ISOLATION LEVEL READ COMMITTED\n\nIF @ID1 IS NOT NULL\nBEGIN\n    SELECT *\n    FROM [dbo].[TestTable]\n    WHERE [Col1] = COALESCE(@Col1, Col1)\n      AND [Col2] = COALESCE(@Col2, Col2)\n      AND [Col3] >= COALESCE(DATEADD(second, 0, DATEDIFF(day, 0, @Col3)), Col3)\n      AND [Col4] <= COALESCE(DATEADD(day, 1, DATEADD(second, -1, DATEDIFF(day, 0, @Col4))), Col4)\n      AND [Col5] IN (SELECT [ID2] FROM [dbo].[TestTable2] WHERE [ID1] = @ID1)\nEND\nELSE\nBEGIN\n    SELECT *\n    FROM [dbo].[TestTable]\n    WHERE [Col1] = COALESCE(@Col1, Col1)\n      AND [Col2] = COALESCE(@Col2, Col2)\n      AND [Col3] >= COALESCE(DATEADD(second, 0, DATEDIFF(day, 0, @Col3)), Col3)\n      AND [Col4] <= COALESCE(DATEADD(day, 1, DATEADD(second, -1, DATEDIFF(day, 0, @Col4))), Col4)\nEND