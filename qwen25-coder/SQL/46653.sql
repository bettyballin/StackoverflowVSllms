UPDATE O\n    SET O.UserID = U.UserID\n    FROM dbo.Orders O\n    INNER JOIN dbo.UsersOld UO ON O.Initials = UO.Initials -- Assuming there's an old users table with initials and ObjectGUIDs\n    INNER JOIN dbo.UserMapping U ON U.ADObjectGUID = UO.ADObjectGUID;