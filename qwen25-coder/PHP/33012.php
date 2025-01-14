<?php\n// handler_question.php\n\ninclude 'handler_login.php'; // This should include db connection and global variables\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $question_body = $_POST['question_body'];\n    $question_title = $_POST['question_title'];\n    $tags = trim($_POST['tags']);\n    $tags_array = explode(',', $tags);\n\n    // Prepare the SQL query safely\n    $sql_questions_question_id = pg_prepare($dbconn, "select_question_id", "SELECT question_id FROM users WHERE username = $1");\n    $result_question_id = pg_execute($dbconn, "select_question_id", array($username));\n\n    if ($result_question_id) {\n        $question_row = pg_fetch_assoc($result_question_id);\n        if ($question_row && isset($question_row['question_id'])) {\n            $questions_question_id = $question_row['question_id'];\n\n            // Insert tags securely\n            foreach ($tags_array as $tag) {\n                // Prepare statement for inserting tags\n                $sql_tags_insert = pg_prepare($dbconn, "insert_tag", "INSERT INTO tags (tag, questions_question_id) VALUES ($1, $2)");\n                pg_execute($dbconn, "insert_tag", array(trim($tag), $questions_question_id));\n            }\n        } else {\n            die("Error retrieving question ID.");\n        }\n    } else {\n        die("Error preparing or executing query for selecting question ID.");\n    }\n}\n\npg_close($dbconn);\n?>