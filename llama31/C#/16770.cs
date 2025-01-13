void updateMediaForSubscribers(long userId, long mediaId, Media_Base.Catagory cat, DateTime currentDate)\n{\n    // ... (insert statement remains the same)\n\n    command.CommandText =\n        "UPDATE user_data SET mediaMsgCount = mediaMsgCount + 1 " +\n        "WHERE userId IN (SELECT watcher FROM user_watch WHERE watched = @watched)";\n    command.Parameters.Add("@watched", DbType.Int64).Value = userId;\n    command.ExecuteNonQuery();\n}