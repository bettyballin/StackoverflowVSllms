CREATE INDEX IX_Stories_LastActivityAt ON Stories (LastActivityAt);\nCREATE INDEX IX_Stories_UserCategoryID ON Stories (UserID, CategoryID);