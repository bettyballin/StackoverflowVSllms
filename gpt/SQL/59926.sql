CREATE PROCEDURE UpdateUserBalance\n    @UserId INT,\n    @Amount DECIMAL(18, 2)\nAS\nBEGIN\n    UPDATE Users\n    SET Balance = Balance + @Amount\n    WHERE UserId = @UserId;\nEND;