CREATE NONCLUSTERED INDEX IX_Objects_UserID ON Objects (UserID) INCLUDE (CategoryID);\nCREATE NONCLUSTERED INDEX IX_Objects_CategoryID ON Objects (CategoryID) INCLUDE (UserID);