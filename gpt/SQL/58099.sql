CREATE TRIGGER trg_athletes_insert\nON athletes\nAFTER INSERT, UPDATE\nAS\nBEGIN\n    DECLARE @student_id INT;\n    SELECT @student_id = student_id FROM inserted;\n    \n    IF EXISTS (SELECT 1 FROM musicians WHERE student_id = @student_id)\n    BEGIN\n        ROLLBACK TRANSACTION;\n        THROW 50002, 'A student cannot be in more than one subclass.', 1;\n    END\nEND;\n\nCREATE TRIGGER trg_musicians_insert\nON musicians\nAFTER INSERT, UPDATE\nAS\nBEGIN\n    DECLARE @student_id INT;\n    SELECT @student_id = student_id FROM inserted;\n    \n    IF EXISTS (SELECT 1 FROM athletes WHERE student_id = @student_id)\n    BEGIN\n        ROLLBACK TRANSACTION;\n        THROW 50003, 'A student cannot be in more than one subclass.', 1;\n    END\nEND;