-- Create a table example\nCREATE TABLE MyTable (\n    ID INT PRIMARY KEY,\n    Data NVARCHAR(100),\n    CreatedAt DATETIME DEFAULT GETDATE(),\n    UpdatedAt DATETIME DEFAULT GETDATE()\n);\n\n-- Create an UPDATE trigger to automatically set the UpdatedAt field on update\nCREATE TRIGGER trg_UpdateTimestamp\nON MyTable\nAFTER UPDATE\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Update the UpdatedAt column to the current date and time for updated records\n    UPDATE t\n    SET UpdatedAt = GETDATE()\n    FROM MyTable t\n    INNER JOIN inserted i ON t.ID = i.ID;\nEND;