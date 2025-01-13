DECLARE @IdsToDelete TABLE (questionId INT);\n\nBEGIN TRANSACTION;\n\nBEGIN TRY\n    INSERT INTO @IdsToDelete (questionId)\n    SELECT questionid FROM tGeoQuizToQuestion WHERE quizId = @quizId;\n\n    DELETE tGeoQuizToQuestion WHERE quizId = @quizId;\n    DELETE tGeoQuestions WHERE id IN (SELECT questionId FROM @IdsToDelete);\n\n    COMMIT TRANSACTION;\nEND TRY\nBEGIN CATCH\n    ROLLBACK TRANSACTION;\n    THROW;\nEND CATCH;