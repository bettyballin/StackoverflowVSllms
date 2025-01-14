SELECT q.id AS question_id, q.title, q.content, u.id AS user_id, u.username\nFROM questions q\nJOIN users u ON q.author_id = u.id;