CREATE PROCEDURE pUpdateStudentStatusHybrid\n    @UpdateTable UpdateStudentStatusTableType READONLY\nAS\nBEGIN\n    -- Update student status\n    UPDATE s\n    SET s.StatusID = u.StatusID\n    FROM Students s\n    INNER JOIN @UpdateTable u ON s.StudentID = u.StudentID;\n\n    -- Call existing procedure for logging\n    DECLARE @StudentID INT, @StatusID INT, @Comments VARCHAR(MAX), @UserID INT;\n    DECLARE cur CURSOR FOR SELECT StudentID, StatusID, Comments, UserID FROM @UpdateTable;\n    OPEN cur;\n\n    FETCH NEXT FROM cur INTO @StudentID, @StatusID, @Comments, @UserID;\n    WHILE @@FETCH_STATUS = 0\n    BEGIN\n        EXEC pUpdateStudentStatus @StudentID, @StatusID, @Comments, @UserID;\n        FETCH NEXT FROM cur INTO @StudentID, @StatusID, @Comments, @UserID;\n    END;\n\n    CLOSE cur;\n    DEALLOCATE cur;\nEND;