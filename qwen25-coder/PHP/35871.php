<?php\n// Sample PHP backend handling data requests\nfunction fetchData() {\n    $data = ['task1', 'task2', 'task3'];\n    return json_encode($data);\n}\n\nheader('Content-Type: application/json');\necho fetchData();\n?>