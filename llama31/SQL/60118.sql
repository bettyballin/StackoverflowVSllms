CREATE TYPE EmailAddress FROM nvarchar(255)\n    NULL\n    CHECK (VALUE LIKE '%@%.%');\nGO