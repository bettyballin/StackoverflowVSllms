CREATE TABLE [dbo].[aspnet_Users] (\n    [ApplicationId] UNIQUEIDENTIFIER NOT NULL,\n    [UserId] UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWSEQUENTIALID(),\n    [UserName] NVARCHAR(256) NOT NULL,\n    -- other user fields...\n);