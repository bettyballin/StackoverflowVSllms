CREATE TABLE UserLogins (\n    LogId INT PRIMARY KEY IDENTITY,\n    UserId INT,\n    LoginDateTime DATETIME,\n    LogoutDateTime DATETIME\n);