$query = "SET @last_question_id := NULL;\n          SELECT \n            a.*,\n            @last_question_id AS question_id\n          FROM \n            andyasks a\n          WHERE \n            a.user != 'Andy'\n            AND (@last_question_id := (SELECT id FROM andyasks WHERE user = 'Andy' AND date_posted < a.date_posted ORDER BY date_posted DESC LIMIT 1)) IS NOT NULL\n          ORDER BY \n            a.date_posted;";\n\n$result = mysql_query($query);\n\nwhile ($row = mysql_fetch_array($result)) {\n    // Process the results here\n    echo $row['questions'] . ' (Answer to question ' . $row['question_id'] . ')';\n}