-- Update Ids in descending order (to avoid conflicts)\nUPDATE YourTableName\nSET Id = Id + 1\nORDER BY Id DESC;