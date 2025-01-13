CREATE FUNCTION dbo.CountComments(@ArticleID INT)\nRETURNS INT \nWITH SCHEMABINDING\nAS BEGIN\n    DECLARE @ArticleCommentCount INT\n\n    SELECT @ArticleCommentCount = COUNT(*)\n    FROM dbo.ArticleComments\n    WHERE ArticleID = @ArticleID\n\n    RETURN @ArticleCommentCount\nEND\nGO