BEGIN TRANSACTION;\n\nBEGIN TRY\n    DELETE tGeoQuizToQuestion WHERE quizId = @quizId;\n    DELETE tGeoQuestions WHERE id IN (SELECT questionid FROM tGeoQuizToQuestion WHERE quizId = @quizId);\n\n    COMMIT TRANSACTION;\nEND TRY\nBEGIN CATCH\n    ROLLBACK TRANSACTION;\n    THROW;\nEND CATCH;