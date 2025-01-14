SELECT\n    questions.qid,\n    questions.question,\n    questions.date,\n    COUNT(comments.cid) AS total_comments\nFROM\n    questions\nLEFT JOIN comments ON comments.qid = questions.qid\nGROUP BY\n    questions.qid, questions.question, questions.date\nORDER BY\n    questions.date;