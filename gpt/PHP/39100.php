<?php\nini_set('display_errors', 1);\nini_set('display_startup_errors', 1);\nerror_reporting(E_ALL);\n\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    if (isset($_FILES['file'])) {\n        echo '<pre>';\n        print_r($_FILES['file']);\n        echo '</pre>';\n    } else {\n        echo 'No file uploaded or invalid file input name.';\n    }\n}\n?>