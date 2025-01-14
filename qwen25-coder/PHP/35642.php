<?php\n\nfunction getStatusFromApp() {\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/api/status");\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n    $status = curl_exec($ch);\n    curl_close($ch);\n\n    return json_decode($status, true);\n}\n\nfunction sendActionToApp($action) {\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, "http://localhost:8080/api/action");\n    curl_setopt($ch, CURLOPT_POST, 1);\n    curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($action));\n    curl_exec($ch);\n    curl_close($ch);\n}\n\n// Example usage\n$status = getStatusFromApp();\nprint_r($status);\n\n$actionData = ['file' => 'example.txt', 'action' => 'upload'];\nsendActionToApp($actionData);\n\n?>