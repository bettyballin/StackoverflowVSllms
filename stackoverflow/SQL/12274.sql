CREATE FUNCTION [dbo].[GetAliasesById]\n(\n    @userID int\n)\nRETURNS varchar(max)\nAS\nBEGIN\n    declare @output varchar(max)\n    select @output = COALESCE(@output + ', ', '') + alias\n    from UserAliases\n    where userid = @userID\n\n    return @output\nEND\n\nGO\n\nSELECT UserID, dbo.GetAliasesByID(UserID)\nFROM UserAliases\nGROUP BY UserID\n\nGO