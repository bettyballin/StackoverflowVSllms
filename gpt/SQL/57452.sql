-- Using JOIN\nSELECT *\nFROM Document\nINNER JOIN DocumentStats ON Document.Id = DocumentStats.DocumentId\nWHERE DocumentStats.NbViews > 500;