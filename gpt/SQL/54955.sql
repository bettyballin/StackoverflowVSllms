DBCC CHECKIDENT ('YourTableName', RESEED, (SELECT MAX(Id) FROM YourTableName));