CREATE TRIGGER trg_UserName_Lowercase\nON YourTableName\nINSTEAD OF INSERT, UPDATE\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Insert the new or updated records with "UserName" set to the lowercase version of "DisplayUserName"\n    INSERT INTO YourTableName (other_columns, UserName, DisplayUserName)\n    SELECT other_columns, LOWER(i.DisplayUserName), i.DisplayUserName\n    FROM inserted i;\nEND;