// Step 3: Use the Access Token to make API calls\n   $access_token = $_SESSION['access_token'];\n   $url = "https://graph.facebook.com/v15.0/me/friends?access_token=" . urlencode($access_token);\n   $response = file_get_contents($url);\n   $friendsList = json_decode($response, true);\n\n   // Return the friends list to your Flash application or handle as needed