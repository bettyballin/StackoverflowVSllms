CREATE TRIGGER trgInsert\nON dbo.usage_reports_Dummy2\nINSTEAD OF INSERT\nAS BEGIN\n    SET NOCOUNT ON; -- Performance optimization\n\n    -- Insert rows with pre-defined logout times directly\n    INSERT INTO dbo.usage_reports_Dummy2(member_id, login_time, logout_time, ip, session_id)\n    SELECT member_id, login_time, logout_time, ip, session_id\n    FROM inserted \n    WHERE logout_time IS NOT NULL;\n\n    -- Insert rows with calculated logout times (random within 1 hour of login)\n    INSERT INTO dbo.usage_reports_Dummy2(member_id, login_time, logout_time, ip, session_id)\n    SELECT member_id, login_time, DATEADD(ss, FLOOR(RAND(CONVERT(INT, NEWID())) * 3600), login_time),\n           ip, session_id\n    FROM inserted \n    WHERE logout_time IS NULL;\nEND