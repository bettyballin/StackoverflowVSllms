CREATE PROCEDURE pBatchUpdateStudentStatus\nAS\nBEGIN\n    -- Create a temporary table to hold the updates\n    CREATE TABLE #StudentsToUpdate (\n        studentID INT,\n        statusID INT,\n        comments NVARCHAR(255),\n        userID INT\n    );\n\n    -- Insert into temp table (example, fill it with necessary data)\n    INSERT INTO #StudentsToUpdate (studentID, statusID, comments, userID)\n    VALUES \n        (1, 2, 'Promoted', 999),\n        (2, 3, 'On Hold', 999);\n\n    -- Declare variables to hold the current row values\n    DECLARE @currentStudentID INT, @currentStatusID INT, @currentComments NVARCHAR(255), @currentUserID INT;\n\n    -- Loop through each record in the temp table and call the existing procedure\n    WHILE EXISTS (SELECT 1 FROM #StudentsToUpdate)\n    BEGIN\n        SELECT TOP 1 \n            @currentStudentID = studentID, \n            @currentStatusID = statusID, \n            @currentComments = comments, \n            @currentUserID = userID \n        FROM #StudentsToUpdate;\n\n        EXEC pUpdateStudentStatus @currentStudentID, @currentStatusID, @currentComments, @currentUserID;\n\n        DELETE TOP (1) FROM #StudentsToUpdate;\n    END;\n\n    -- Clean up temp table\n    DROP TABLE #StudentsToUpdate;\nEND;\nGO