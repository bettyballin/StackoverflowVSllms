<?php\nif (isset($_COOKIE['formData'])) {\n    $formData = json_decode($_COOKIE['formData'], true);\n    // Use $formData to filter search results or other logic\n}\n?>