$question = isset($_POST['question']) ? trim($_POST['question']) : '';\n\nif (empty($question) && $question !== '0') {\n    // Handle error here\n}