CREATE PROCEDURE greet @name nvarchar(50) AS\nBEGIN\n  PRINT 'Hello, ' + @name + '!';\nEND;