CREATE PROCEDURE MyProc\n    @MyDate DATETIME = NULL\nAS\n    DECLARE @MyDate_Copy DATETIME\n    SET @MyDate_Copy = @MyDate\n    IF @MyDate_Copy IS NULL SET @MyDate_Copy = CURRENT_TIMESTAMP\n    -- Do Something using @MyDate_Copy