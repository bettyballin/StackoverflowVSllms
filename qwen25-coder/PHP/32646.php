$cred = $_POST['twitter_username'].':'.$_POST['twitter_password'];\n$url = "https://api.twitter.com/1.1/account/verify_credentials.json"; // Use HTTPS\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Add this line\ncurl_setopt($ch, CURLOPT_USERPWD, $cred);\n$result = curl_exec($ch);\ncurl_close($ch);\n\n// Now you can handle the response in $result as a string