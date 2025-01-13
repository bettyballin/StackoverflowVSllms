BEGIN TRANSACTION;\n\nUPDATE Authors\nSET Name = @NewName, Bio = @NewBio\nWHERE AuthorID = @AuthorID;\n\nINSERT INTO AuthorVersions (VersionID, AuthorID, Name, Bio, Timestamp)\nVALUES (@VersionID, @AuthorID, @NewName, @NewBio, GETDATE());\n\nCOMMIT;