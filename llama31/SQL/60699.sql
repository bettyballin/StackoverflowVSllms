CREATE PROCEDURE MyProcedure\nAS\nBEGIN\n    -- Retrieve the user's ID from CONTEXT_INFO\n    DECLARE @UserId nvarchar(50)\n    SELECT @UserId = CONVERT(nvarchar(50), CONTEXT_INFO())\n\n    -- Use the user's ID as needed\n    PRINT 'User ID: ' + @UserId\n\n    -- Perform other operations\nEND