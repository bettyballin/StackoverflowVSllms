-- Create the view\nCREATE VIEW dbo.vHelpfulPostCounts\nWITH SCHEMABINDING\nAS\nSELECT\n    PostId,\n    COUNT_BIG(CASE WHEN IsHelpful = 1 THEN 1 ELSE NULL END) AS IsHelpfulCount,\n    COUNT_BIG(CASE WHEN IsHelpful = 0 THEN 1 ELSE NULL END) AS IsNotHelpfulCount\nFROM\n    dbo.HelpfulPosts\nGROUP BY\n    PostId;\nGO\n\n-- Create a unique clustered index on the view\nCREATE UNIQUE CLUSTERED INDEX IX_vHelpfulPostCounts\nON dbo.vHelpfulPostCounts (PostId);\nGO\n\n-- Create a non-clustered index on the PostId column\nCREATE NONCLUSTERED INDEX IX_PostId\nON dbo.vHelpfulPostCounts (PostId);\nGO