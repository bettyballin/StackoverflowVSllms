CREATE TABLE CustomTable\n(\n    Id INT PRIMARY KEY,\n    UserId UNIQUEIDENTIFIER,  -- GUID-based User ID\n    UserIdInt INT  -- integer-based column for indexing and querying\n)