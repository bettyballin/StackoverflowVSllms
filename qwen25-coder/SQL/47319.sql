IF EXISTS (SELECT * FROM sys.server_principals WHERE name = 'loginname')\nBEGIN\n    PRINT 'Login exists.'\nEND\nELSE\nBEGIN\n    PRINT 'Login does not exist.'\nEND