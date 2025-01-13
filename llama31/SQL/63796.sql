CREATE TRIGGER [dbo].[BeforeUpdateUser]\n   ON  [dbo].[Users]\n   INSTEAD OF UPDATE\nAS \nBEGIN\n    -- SET NOCOUNT ON added to prevent extra result sets from\n    -- interfering with SELECT statements.\n    SET NOCOUNT ON;\n\n    DECLARE @Email nvarchar(255)\n    DECLARE @UserName nvarchar(255)\n    DECLARE @UserId int\n    DECLARE @DoUpdate bit\n\n    SET @DoUpdate = 1\n\n    SELECT @Email = Email, @UserName = UserName FROM INSERTED\n\n    SELECT @UserId = UserId FROM Users WHERE Email = @Email AND UserId <> (SELECT UserId FROM INSERTED)\n\n    IF (@UserId IS NOT NULL)\n        BEGIN\n            SET @DoUpdate = 0\n        END\n\n    SELECT @UserId = UserId FROM Users WHERE UserName = @UserName AND UserId <> (SELECT UserId FROM INSERTED)\n\n    IF (@UserId IS NOT NULL)\n        BEGIN\n            SET @DoUpdate = 0\n        END\n\n    IF (@DoUpdate = 1)\n        BEGIN\n            UPDATE u\n            SET u.FirstName = i.FirstName,\n                u.LastName = i.LastName,\n                u.Email = i.Email,\n                u.Password = i.Password,\n                u.UserName = i.UserName,\n                u.LanguageId = i.LanguageId,\n                u.Data = i.Data,\n                u.IsDeleted = i.IsDeleted\n            FROM Users u\n            INNER JOIN INSERTED i ON u.UserId = i.UserId\n        END\n    ELSE\n        BEGIN\n            DECLARE @ErrorMessage nvarchar(MAX)\n            SET @ErrorMessage = \n                         'The username and emailadress of a user must be unique!'\n            RAISERROR 50001 @ErrorMessage\n        END \nEND