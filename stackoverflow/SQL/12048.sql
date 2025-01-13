SELECT TheDay, AVG(TimeTaken) AvgTimeTaken\nFROM (  \nSELECT \n    CONVERT(DATE, logins.DateTimeStamp) TheDay\n    , DATEDIFF(SS, logins.DateTimeStamp, \n                (SELECT TOP 1 DateTimeStamp \n                 FROM AuditData userinfo \n                 WHERE UserID=logins.UserID \n                    and userinfo.ActivityCode=2 \n                    and userinfo.DateTimeStamp > logins.DateTimeStamp )\n                )TimeTaken\nFROM AuditData logins\nWHERE \n    logins.ActivityCode = 1\n) LogInTimes\nGROUP BY TheDay