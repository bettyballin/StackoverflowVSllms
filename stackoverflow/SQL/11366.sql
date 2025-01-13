set nocount on\n\ncreate table Timesheet_Hours (Staff_Id int, BookedHours int, Posted_Flag bit)\n\ninsert into Timesheet_Hours (Staff_Id, BookedHours, Posted_Flag) values (1, 5.5, 0)\n\ndeclare @PersonID int\nset @PersonID = 1\n\nIF EXISTS    \n    (\n    SELECT 1    \n    FROM Timesheet_Hours    \n    WHERE Posted_Flag = 1    \n        AND Staff_Id = @PersonID    \n    )    \n    BEGIN\n        RAISERROR('Timesheets have already been posted!', 16, 1)\n        ROLLBACK TRAN\n    END\nELSE\n    IF NOT EXISTS\n        (\n        SELECT 1\n        FROM Timesheet_Hours\n        WHERE Staff_Id = @PersonID\n        )\n        BEGIN\n            RAISERROR('Default list has not been loaded!', 16, 1)\n            ROLLBACK TRAN\n        END\n    ELSE\n        print 'No problems here'\n\ndrop table Timesheet_Hours