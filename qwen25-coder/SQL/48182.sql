SELECT \n    q.question_id,\n    q.question_text,\n    a.answer_id,\n    a.answer_text,\n    COUNT(adq.user_ip) AS answer_count\nFROM \n    Questions q\nLEFT JOIN \n    Answers a ON q.question_id = a.question_id\nLEFT JOIN \n    Answered_Questions adq ON a.answer_id = adq.answer_id AND q.question_id = adq.question_id\nWHERE \n    q.created_at = (SELECT MAX(created_at) FROM Questions)\nGROUP BY \n    q.question_id, q.question_text, a.answer_id, a.answer_text;