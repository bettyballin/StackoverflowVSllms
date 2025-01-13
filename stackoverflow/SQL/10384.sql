CREATE PROCEDURE UpdateTables\nAS\nBEGIN\n    -- SET NOCOUNT ON added to prevent extra result sets from\n    -- interfering with SELECT statements.\n    SET NOCOUNT ON;\n    DECLARE @RowCount1 INTEGER\n    DECLARE @RowCount2 INTEGER\n    DECLARE @RowCount3 INTEGER\n    DECLARE @RowCount4 INTEGER\n\n    UPDATE Table1 Set Column = 0 WHERE Column IS NULL\n    SELECT @RowCount1 = @@ROWCOUNT\n    UPDATE Table2 Set Column = 0 WHERE Column IS NULL\n    SELECT @RowCount2 = @@ROWCOUNT\n    UPDATE Table3 Set Column = 0 WHERE Column IS NULL\n    SELECT @RowCount3 = @@ROWCOUNT\n    UPDATE Table4 Set Column = 0 WHERE Column IS NULL\n    SELECT @RowCount4 = @@ROWCOUNT\n\n    SELECT @RowCount1 AS Table1, @RowCount2 AS Table2, @RowCount3 AS Table3, @RowCount4 AS Table4\nEND