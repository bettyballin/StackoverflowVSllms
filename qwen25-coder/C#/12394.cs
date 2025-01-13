public bool ValidateComment(Comment comment) {\n       if (comment.QuestionId <= 0) return false;\n       // Check if the Question ID exists in the database\n       var question = _context.Questions.Find(comment.QuestionId);\n       if (question == null) return false;\n\n       return true;\n   }