INSERT INTO Authors_History (Timestamp, UserId, OperationTypeId, AuthorId, Name)\nVALUES (GETDATE(), @UserId, 1, @AuthorId, @OldAuthorName);