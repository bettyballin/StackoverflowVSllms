CREATE PROCEDURE GetUser\n    @username nvarchar(50)\nAS\nBEGIN\n    SELECT * FROM users WHERE username = @username\nEND