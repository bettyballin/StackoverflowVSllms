function isEmpty($input) {\n    return !isset($input) || trim($input) === '';\n}\n\n$question = $_POST['question'];\n\nif (isEmpty($question)) {\n    // Handle error here\n}