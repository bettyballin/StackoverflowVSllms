// Handling a form submission explicitly with $_POST\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $name = $_POST["name"];\n    // Proceed with validation and processing\n}\n\n// Handling URL parameters explicitly with $_GET\nif ($_SERVER["REQUEST_METHOD"] == "GET") {\n    $id = $_GET["id"];\n    // Proceed with validation and processing\n}