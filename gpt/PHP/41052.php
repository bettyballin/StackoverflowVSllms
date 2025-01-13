<?php\nfunction searchAnotherSite($query) {\n    $url = "https://example.com/search"; // Replace with the target site's search URL\n    $params = http_build_query(['q' => $query]); // Adjust parameter name accordingly\n\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url . '?' . $params);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n    \n    $response = curl_exec($ch);\n    \n    if (curl_errno($ch)) {\n        echo 'Error:' . curl_error($ch);\n    }\n    \n    curl_close($ch);\n    \n    return $response; // This will contain the HTML or JSON response from the target site\n}\n\n// Example usage\n$searchResult = searchAnotherSite('example search query');\necho $searchResult;\n?>