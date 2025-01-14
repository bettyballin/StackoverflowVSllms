CREATE TABLE UrlRewrites (\n    ID INT IDENTITY(1,1) PRIMARY KEY,\n    URLRewritten VARCHAR(MAX) NOT NULL,\n    OriginalURL VARCHAR(MAX) NOT NULL,\n    CONSTRAINT UQ_URLRewritten UNIQUE (URLRewritten),\n    CONSTRAINT UQ_OriginalURL UNIQUE (OriginalURL)\n);\n\n-- Create indexes to optimize lookups\nCREATE INDEX IDX_URLRewritten ON UrlRewrites (URLRewritten);\nCREATE INDEX IDX_OriginalURL ON UrlRewrites (OriginalURL);