<?php\nheader('Content-Type: application/json');\n// Simulate fetching game data\n$data = [\n    ['tile' => 1, 'type' => 'grass'],\n    ['tile' => 2, 'type' => 'water'],\n    // more tiles...\n];\n\necho json_encode($data);\n?>