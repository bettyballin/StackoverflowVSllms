SELECT d.date_name, q.question_text, ua.answer_val\nFROM user_answers ua\nJOIN dates d ON ua.date_id = d.date_id\nJOIN questions q ON ua.question_id = q.question_id\nWHERE ua.user_id = ?;