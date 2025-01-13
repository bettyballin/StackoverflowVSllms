BEGIN TRANSACTION;\n\nINSERT INTO Authors (AuthorID, Name, Bio)\nVALUES (@AuthorID, @Name, @Bio);\n\nINSERT INTO AuthorVersions (VersionID, AuthorID, Name, Bio, Timestamp)\nVALUES (@VersionID, @AuthorID, @Name, @Bio, GETDATE());\n\nCOMMIT;