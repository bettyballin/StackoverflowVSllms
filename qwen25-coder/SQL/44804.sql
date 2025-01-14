CREATE TABLE MediaAssets (\n      Id INT IDENTITY(1,1) PRIMARY KEY,\n      FilePath NVARCHAR(MAX),\n      ContentType NVARCHAR(50), -- e.g., 'image/jpeg', 'audio/wav'\n      Description NVARCHAR(MAX)\n  );