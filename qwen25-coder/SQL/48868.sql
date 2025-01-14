-- Table for storing views\nCREATE TABLE ArticleViews (\n    ViewID INT IDENTITY(1,1) PRIMARY KEY,\n    ArticleID INT NOT NULL,\n    ViewDate DATETIME NOT NULL DEFAULT GETDATE(),\n    CONSTRAINT FK_ArticleViews_Articles FOREIGN KEY (ArticleID) REFERENCES Articles(ID)\n);\n\n-- Procedure to log each view\nCREATE PROCEDURE LogArticleView\n(\n    @ArticleID int\n)\nAS\nBEGIN TRANSACTION\n\nINSERT INTO ArticleViews (ArticleID)\nVALUES (@ArticleID)\n\nIF @@ERROR <> 0\nBEGIN\n    -- Rollback the transaction\n    ROLLBACK\n\n    -- Raise an error and return\n    RAISERROR ('Error Logging View', 16, 1)\n    RETURN\nEND\n\nCOMMIT