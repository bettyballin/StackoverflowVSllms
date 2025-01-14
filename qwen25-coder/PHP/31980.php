// Include TwitterOAuth library\nrequire "path/to/vendor/autoload.php";\nuse Abraham\TwitterOAuth\TwitterOAuth;\n\n// Your app credentials from Twitter Developer Portal\n$apiKey = 'YOUR_API_KEY';\n$apiSecretKey = 'YOUR_APP_SECRET_KEY';\n$accessToken = 'ACCESS_TOKEN';\n$accessTokenSecret = 'ACCESS_TOKEN_SECRET';\n\n// Create a new connection to the API using your credentials\n$connection = new TwitterOAuth($apiKey, $apiSecretKey, $accessToken, $accessTokenSecret);\n\n// Make requests to Twitter's REST API with your connection handle\n$content = $connection->get("account/verify_credentials");\n\necho json_encode($content);