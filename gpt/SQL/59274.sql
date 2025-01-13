CREATE PROCEDURE AccountTable_Update\n    @Id INT,\n    @FirstName NVARCHAR(50),     \n    @LastName NVARCHAR(50), \n    @Street NVARCHAR(50),\n    @StateId INT\nAS\nBEGIN\n    UPDATE AccountTable\n    SET \n        FirstName = @FirstName,\n        LastName = @LastName,\n        Street = @Street,\n        StateId = @StateId\n    WHERE AccountId = @Id\nEND