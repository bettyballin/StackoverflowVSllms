-- Declare variables for source and target categories\nDECLARE @fromCategoryID INT = 1;\nDECLARE @toCategoryID INT = 2;\n\n-- Copy questions from source category to target category\nINSERT INTO Questions (Question, CategoryID)\nSELECT q.Question, @toCategoryID AS NewCategoryID\nFROM Questions q\nWHERE q.CategoryID = @fromCategoryID\nOUTPUT inserted.QuestionID\nINTO #TempQuestions -- Use table variable to store the new IDs\n;\n\n-- Copy selections from each question in source category to corresponding questions in target category\nINSERT INTO Selections (Selection, QuestionID)\nSELECT s.Selection, t.NewQuestionID\nFROM Selections s\nJOIN Questions q ON s.QuestionID = q.QuestionID\nJOIN #TempQuestions t ON q.QuestionID = t.OldQuestionID\n;\n\n-- Drop the temporary table after use\nDROP TABLE #TempQuestions;