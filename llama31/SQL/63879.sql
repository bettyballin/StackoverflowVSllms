CREATE PROCEDURE GetUserData\n    @UserName nvarchar(50)\nAS\nBEGIN\n    DECLARE @SQL nvarchar(max) = N'SELECT * FROM Users WHERE UserName = @UserName';\n    EXEC SP_EXECUTESQL @SQL, N'@UserName nvarchar(50)', @UserName = @UserName;\nEND;