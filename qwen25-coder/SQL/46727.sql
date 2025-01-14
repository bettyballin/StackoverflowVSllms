-- Create a table to store audit data\nCREATE TABLE EmployeeAudit (\n    AuditLogID INT IDENTITY PRIMARY KEY,\n    EmployeeID INT,\n    ColumnName NVARCHAR(128),\n    OldValue NVARCHAR(MAX),\n    NewValue NVARCHAR(MAX),\n    UpdatedDate DATETIME DEFAULT GETDATE(),\n    ModifiedBy NVARCHAR(128) DEFAULT SUSER_SNAME()\n);\n\n-- Create an audit trigger\nCREATE TRIGGER trg_AuditEmployeeChanges\nON Employee\nAFTER UPDATE\nAS\nBEGIN\n    SET NOCOUNT ON;\n\n    -- Insert into the audit log only if the value in a specific column is changed\n    INSERT INTO EmployeeAudit (EmployeeID, ColumnName, OldValue, NewValue)\n    SELECT \n        d.EmployeeID,\n        'FirstName',\n        d.FirstName AS OldValue,\n        i.FirstName AS NewValue\n    FROM deleted d\n    JOIN inserted i ON d.EmployeeID = i.EmployeeID\n    WHERE d.FirstName <> i.FirstName;\n\n    INSERT INTO EmployeeAudit (EmployeeID, ColumnName, OldValue, NewValue)\n    SELECT \n        d.EmployeeID,\n        'LastName',\n        d.LastName AS OldValue,\n        i.LastName AS NewValue\n    FROM deleted d\n    JOIN inserted i ON d.EmployeeID = i.EmployeeID\n    WHERE d.LastName <> i.LastName;\n\n    -- Repeat for other columns you want to audit\nEND;