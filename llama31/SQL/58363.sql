-- Example of a well-structured stored procedure\nCREATE PROCEDURE sp_GetUserDetails\n    @UserId INT\nAS\nBEGIN\n    SELECT \n        u.UserName, \n        u.Email, \n        u.LastLoginDate\n    FROM \n        Users u\n    WHERE \n        u.UserId = @UserId;\nEND;\nGO