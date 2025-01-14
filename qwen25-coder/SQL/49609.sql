-- If the URL format is consistent, consider using LEFT, RIGHT, SUBSTRING, or PATINDEX.\nCREATE INDEX idx_PageUrl ON PageViews(PageUrl);\n\n-- However, for full-text search:\nCREATE FULLTEXT CATALOG MyFTCatalog;\nCREATE FULLTEXT INDEX ON PageViews(PageUrl) KEY INDEX YourPrimaryKeyIndex ON MyFTCatalog;