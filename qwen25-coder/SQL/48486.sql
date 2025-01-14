CREATE TRIGGER after_job_person_delete AFTER DELETE ON JOB_PERSON \nFOR EACH ROW \nBEGIN ATOMIC\n    IF NOT EXISTS (SELECT * FROM JOB_PERSON WHERE JOB_ID = OLD.JOB_ID) THEN\n        DELETE FROM JOB WHERE JOB_ID = OLD.JOB_ID;\n    END IF;\nEND;\n\nCREATE TRIGGER after_person_delete AFTER DELETE ON PERSON \nFOR EACH ROW \nBEGIN ATOMIC\n    -- This trigger doesn't need additional action beyond the cascades you have set up,\n    -- but it's here for clarity and to ensure no additional logic is missed.\nEND;