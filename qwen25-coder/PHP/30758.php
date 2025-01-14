// Simple API endpoint in PHP\n<?php\nheader("Content-Type: application/json");\n\nfunction get_data() {\n    // Simulate database access\n    $data = ['name' => 'John Doe', 'age' => 30];\n    return json_encode($data);\n}\n\necho get_data();\n?>