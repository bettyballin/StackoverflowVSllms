<?php\nif (isset($_POST['url'])) {\n    $url = $_POST['url'];\n\n    // Initialize cURL session\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n\n    // Execute cURL session\n    $output = curl_exec($ch);\n\n    // Close cURL session\n    curl_close($ch);\n\n    if ($output) {\n        // You might want to sanitize or format the output here\n        echo $output;\n    } else {\n        echo 'Failed to fetch preview.';\n    }\n} else {\n    echo 'No URL provided.';\n}\n?>