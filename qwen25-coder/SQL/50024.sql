-- Add a new GUID column\nALTER TABLE YourTableName ADD NewGuidColumn UNIQUEIDENTIFIER DEFAULT NEWID();\n\n-- Ensure each row has a unique GUID (in case of clustered index or sequential GUIDs use)\nUPDATE YourTableName SET NewGuidColumn = NEWSEQUENTIALID();\n\n-- Optionally, if you want to make the GUID column a primary key:\nALTER TABLE YourTableName DROP CONSTRAINT PK_YourCurrentPrimaryKey;\nALTER TABLE YourTableName ADD PRIMARY KEY CLUSTERED (NewGuidColumn);