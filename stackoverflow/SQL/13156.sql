SELECT s.id, s.title, s.desc\nFROM Section as s \nWHERE EXISTS (SELECT * FROM Quest-Ans as q where q.Sec_id = s.id)