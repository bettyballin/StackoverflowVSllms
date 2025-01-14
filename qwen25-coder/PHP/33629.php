<?php\n\n$apiKey = 'YOUR_API_KEY';\n$apiSecretKey = 'YOUR_API_SECRET_KEY';\n$bearerToken = 'YOUR_BEARER_TOKEN'; // Use Bearer Token directly for v2 API\n$searchTerm = 'SEARCH_TERM_HERE';\n$maxResultsPerPage = 100; // Maximum number of results per page\n\nfunction searchTweets($searchTerm, $nextToken = null) {\n    global $bearerToken, $maxResultsPerPage;\n    \n    $url = "https://api.twitter.com/2/tweets/search/recent?query=" \n         . urlencode($searchTerm) \n         . "&tweet.fields=created_at&max_results=" . $maxResultsPerPage;\n\n    if ($nextToken) {\n        $url .= "&next_token=" . $nextToken;\n    }\n\n    // Initialize cURL session\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n    curl_setopt($ch, CURLOPT_HTTPHEADER, [\n        "Authorization: Bearer " . $bearerToken\n    ]);\n\n    // Execute request and decode JSON response\n    $responseJson = curl_exec($ch);\n    $responseData = json_decode($responseJson, true);\n\n    // Close cURL session\n    curl_close($ch);\n\n    return $responseData;\n}\n\n// Function to handle pagination and data storage\nfunction fetchDataAndStore() {\n    global $searchTerm;\n\n    $nextToken = null;\n    do {\n        $tweetsData = searchTweets($searchTerm, $nextToken);\n        // Store or process each tweet here - add logic for DB insertion/file writing\n        if (isset($tweetsData['data'])) {\n            foreach ($tweetsData['data'] as $tweet) {\n                echo "Tweet: " . $tweet['text'] . PHP_EOL;\n                // Example: Add code to insert into database\n                // dbInsert($tweet);\n            }\n        }\n\n        // Update nextToken only if it exists in the response\n        $nextToken = isset($tweetsData['meta']['next_token']) ? $tweetsData['meta']['next_token'] : null;\n\n    } while ($nextToken !== null); // Continue to fetch until no more pages remain\n\n}\n\nfetchDataAndStore();\n\n?>