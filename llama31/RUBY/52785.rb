questions = Question.where("id NOT IN (SELECT question_id FROM levels_questions WHERE level_id = 15)")\n                   .select(:id, :name)