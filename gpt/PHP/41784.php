if ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    if (!isset($_POST['textarea_name'])) {\n        error_log("Textarea input missing in POST request");\n    }\n}