WITH RequiredKeywords AS (\n  SELECT '25' AS keyword1, '566' AS keyword2 UNION ALL\n  SELECT '156', '166' UNION ALL\n  SELECT '7345', NULL  -- assuming 7345 can appear alone\n)\nSELECT DISTINCT ak.article_id\nFROM ArticleKeywords ak\nJOIN RequiredKeywords rk ON ak.keyword_id = rk.keyword1\nJOIN ArticleKeywords ak2 ON ak.article_id = ak2.article_id AND ak2.keyword_id = rk.keyword2\nWHERE rk.keyword2 IS NOT NULL\nOR (rk.keyword2 IS NULL AND ak.keyword_id = rk.keyword1);