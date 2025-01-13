DECLARE @ApplicationId uniqueidentifier\n   SELECT @ApplicationId = ApplicationId FROM aspnet_Applications WHERE ApplicationName = 'YourApplicationName'\n\n   INSERT INTO aspnet_Users (ApplicationId, UserId, UserName, LoweredUserName, IsAnonymous, LastActivityDate)\n   VALUES (@ApplicationId, NEWID(), 'newUser', LOWER('newUser'), 0, GETDATE())\n\n   INSERT INTO aspnet_Membership (ApplicationId, UserId, Password, PasswordFormat, PasswordSalt, Email, PasswordQuestion, PasswordAnswer, IsApproved, IsLockedOut, CreateDate, LastLoginDate, LastPasswordChangedDate, LastLockoutDate, FailedPasswordAttemptCount, FailedPasswordAttemptWindowStart, FailedPasswordAnswerAttemptCount, FailedPasswordAnswerAttemptWindowStart, Comment)\n   VALUES (@ApplicationId, (SELECT UserId FROM aspnet_Users WHERE UserName = 'newUser'), 'hashedPassword', 1, 'passwordSalt', 'user@example.com', 'PasswordQuestion', 'PasswordAnswer', 1, 0, GETDATE(), GETDATE(), GETDATE(), GETDATE(), 0, GETDATE(), 0, GETDATE(), NULL)