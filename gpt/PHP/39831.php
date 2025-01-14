<?php\n// Twitter API credentials\n$api_key = 'YOUR_API_KEY';\n$api_secret_key = 'YOUR_API_SECRET_KEY';\n$access_token = 'YOUR_ACCESS_TOKEN';\n$access_token_secret = 'YOUR_ACCESS_TOKEN_SECRET';\n\n// File to store cached data\n$cache_file = 'twitter_cache.json';\n// Cache duration in seconds (e.g., 10 minutes)\n$cache_duration = 600;\n\n// Function to fetch tweets\nfunction fetch_tweets($api_key, $api_secret_key, $access_token, $access_token_secret) {\n    // Twitter API endpoint\n    $url = 'https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=your_client_screen_name&count=5';\n\n    // Create a cURL handle\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n    curl_setopt($ch, CURLOPT_HTTPHEADER, [\n        "Authorization: Bearer $access_token"\n    ]);\n\n    // Execute cURL request\n    $response = curl_exec($ch);\n    curl_close($ch);\n\n    return json_decode($response, true);\n}\n\n// Check if cache file exists and is still valid\nif (file_exists($cache_file) && (time() - filemtime($cache_file)) < $cache_duration) {\n    // Use cached data\n    $tweets = json_decode(file_get_contents($cache_file), true);\n} else {\n    // Fetch fresh data from Twitter API\n    $tweets = fetch_tweets($api_key, $api_secret_key, $access_token, $access_token_secret);\n\n    // Save data to cache file\n    file_put_contents($cache_file, json_encode($tweets));\n}\n\n// Output tweets (customize this part as needed)\nforeach ($tweets as $tweet) {\n    echo '<p>' . htmlspecialchars($tweet['text']) . '</p>';\n}\n?>