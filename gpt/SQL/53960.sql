SELECT q.question_id, q.question_text\nFROM Questions q\nLEFT JOIN UserAnswers ua ON q.question_id = ua.question_id AND ua.user_id = ?\nWHERE ua.question_id IS NULL\nLIMIT 1;