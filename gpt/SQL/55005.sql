CREATE PROCEDURE YourStoredProcedure\nAS\nBEGIN\n    SET NOCOUNT ON;\n    \n    -- Set the transaction isolation level to READ UNCOMMITTED\n    SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;\n\n    -- Your SELECT statements here will behave as if (NOLOCK) hint is used\n    SELECT * FROM YourTable;\n\n    -- Reset the transaction isolation level if necessary\n    -- SET TRANSACTION ISOLATION LEVEL READ COMMITTED;\n\nEND;