CREATE TRIGGER trg_CheckUniqueAnswerInActiveSurveys\nON SurveyAnswer\nINSTEAD OF INSERT, UPDATE\nAS\nBEGIN\n    IF EXISTS (\n        SELECT 1 \n        FROM inserted i\n            INNER JOIN Survey s ON i.SurveyId = s.SurveyId\n        WHERE s.Active = 1 AND \n              EXISTS (\n                  SELECT 1 \n                  FROM SurveyAnswer sa2\n                  WHERE sa2.SurveyDomainId = i.SurveyDomainId AND \n                        sa2.Answer = i.Answer AND \n                        sa2.SurveyId IN (SELECT SurveyId FROM Survey WHERE Active = 1)\n              )\n    )\n    BEGIN\n        ROLLBACK TRANSACTION;\n        RAISERROR ('The answer must be unique within all active surveys for the given survey domain.', 16, 1);\n    END\n    ELSE\n    BEGIN\n        INSERT INTO SurveyAnswer (SurveyId, Answer) -- Include other columns as necessary\n        SELECT SurveyId, Answer FROM inserted; -- Include other columns as necessary\n    END\nEND;