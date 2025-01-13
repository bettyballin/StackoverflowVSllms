CREATE PROCEDURE sp_InsertArticle\n    @ArticleName nvarchar(255),\n    @ArticleBody nvarchar(max),\n    @ArticleTags nvarchar(max)\nAS\nBEGIN\n    -- Insert article and get article ID\n    DECLARE @ArticleID int;\n    INSERT INTO dbo.Articles (ArticleName, ArticleBody)\n    VALUES (@ArticleName, @ArticleBody);\n    SET @ArticleID = SCOPE_IDENTITY();\n\n    -- Split tags into a temporary table\n    DECLARE @Tags TABLE (Tag nvarchar(50));\n    INSERT INTO @Tags (Tag)\n    SELECT value\n    FROM STRING_SPLIT(@ArticleTags, ' ');\n\n    -- Insert tags into dbo.Tags table, checking for duplicates\n    MERGE INTO dbo.Tags AS target\n    USING @Tags AS source\n    ON target.Tag = source.Tag\n    WHEN NOT MATCHED THEN\n        INSERT (Tag)\n        VALUES (source.Tag);\n\n    -- Insert article-tag mappings into dbo.TagMap table\n    INSERT INTO dbo.TagMap (ArticleID, TagID)\n    SELECT @ArticleID, t.TagID\n    FROM @Tags AS s\n    JOIN dbo.Tags AS t ON s.Tag = t.Tag;\nEND;