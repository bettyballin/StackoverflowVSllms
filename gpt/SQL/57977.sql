DECLARE @partialKeywordString NVARCHAR(4000) = 'batman* AND be*'; -- Adjust as needed for your input\n\n-- Full-text search results\nSELECT f.title, f_key.Rank\nINTO #FTSResults\nFROM Films f\nINNER JOIN CONTAINSTABLE(Films, Title, @partialKeywordString) f_key ON f.filmid = f_key.[key];\n\n-- Exact and prefix matches using LIKE\nSELECT title, 1000 AS Rank\nINTO #LikeResults\nFROM Films\nWHERE Title LIKE 'batman%' OR Title LIKE '% batman%';\n\n-- Combine and rank results\nSELECT title\nFROM (\n    SELECT title, Rank FROM #FTSResults\n    UNION ALL\n    SELECT title, Rank FROM #LikeResults\n) AS CombinedResults\nORDER BY Rank DESC, title;\n\n-- Cleanup temporary tables\nDROP TABLE #FTSResults;\nDROP TABLE #LikeResults;