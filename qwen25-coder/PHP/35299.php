<?php\n\nfunction fetchGoogleResults($query, $pages) {\n    $results = [];\n    for ($page = 0; $page < $pages * 10; $page += 10) { // Increment by 10 to move to the next page\n        $url = "https://www.google.com/search?q=" . urlencode($query) . "&start=$page";\n        \n        $ch = curl_init();\n        curl_setopt($ch, CURLOPT_URL, $url);\n        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n        curl_setopt($ch, CURLOPT_USERAGENT, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3');\n        \n        $response = curl_exec($ch);\n        if(curl_errno($ch)) {\n            echo 'Curl error: ' . curl_error($ch);\n        }\n        curl_close($ch);\n\n        // Here you would parse the HTML content\n        // For simplicity, we're just appending to results array\n        $results[] = $response; \n    }\n    return $results;\n}\n\n$searchResults = fetchGoogleResults('your search query', 3);\nforeach ($searchResults as $result) {\n    echo $result;\n}\n\n?>