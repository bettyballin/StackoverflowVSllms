SELECT * FROM student_outcomes\nWHERE lft BETWEEN (SELECT lft FROM student_outcomes WHERE id = <node_id>) AND (SELECT rgt FROM student_outcomes WHERE id = <node_id>)\nORDER BY lft;