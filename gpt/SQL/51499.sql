CREATE FUNCTION dbo.GetNumberOfTasks(@CustomerId INT)\n    RETURNS INT\n    AS\n    BEGIN\n        DECLARE @TaskCount INT\n        SELECT @TaskCount = COUNT(*) FROM Tasks WHERE CustomerId = @CustomerId\n        RETURN @TaskCount\n    END