CREATE PROCEDURE GetSimilarArticles\n    @SearchTerm NVARCHAR(255)\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    SELECT TOP 10\n        ArticleID,\n        ArticleTitle,\n        ArticleContent,\n        KEY_TBL.RANK AS Relevance\n    FROM\n        Articles\n    INNER JOIN\n        CONTAINSTABLE(Articles, (ArticleTitle, ArticleContent), @SearchTerm) AS KEY_TBL\n    ON\n        Articles.ArticleID = KEY_TBL.[KEY]\n    ORDER BY\n        KEY_TBL.RANK DESC;\nEND\nGO